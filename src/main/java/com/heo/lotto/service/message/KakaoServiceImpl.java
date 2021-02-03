package com.heo.lotto.service.message;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class KakaoServiceImpl implements MessageService {

    RestTemplate restTemplate;

    @Value("${kakao.talk.key}")
    String KAKAO_KEY;

    @Value("${kakao.talk.sendme}")
    String SEND_ME_URL;

    public KakaoServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean sendMessage(String msg) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + KAKAO_KEY);

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> body = new HashMap<String, Object>();

        Map<String, Object> link = new HashMap<String, Object>();
        link.put("web_url", "");
        link.put("mobile_web_url", "");
        link.put("button_title", "btn");

        Map<String, Object> template_object = new HashMap<String, Object>();
        template_object.put("link", link);
        template_object.put("object_type", "text");
        template_object.put("text", "test message");
        String json = "";
        try {
            json = mapper.writeValueAsString(template_object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            body.put("template_object", URLEncoder.encode(json, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

       HttpEntity entity = new HttpEntity(body,headers);
       
       UriComponents uri = UriComponentsBuilder.fromHttpUrl(SEND_ME_URL).build();

        ResponseEntity result = restTemplate
               .postForEntity(
                uri.toString() 
        ,  entity, ResponseEntity.class);

       System.out.println("result : " + result);

        return false;
    }

    // curl 
    // -X POST "https://kapi.kakao.com/v2/api/talk/memo/default/send" 
    // -H "Content-Type: application/x-www-form-urlencoded" 
    // -H "Authorization: " 
    // -d "template_object=%7B%22object_type%22%3A%20%22text%22%2C%22text%22%3A%20%22%ED%85%8D%EC%8A%A4%ED%8A%B8%20%EC%98%81%EC%97%AD%EC%9E%85%EB%8B%88%EB%8B%A4.%20%EC%B5%9C%EB%8C%80%20200%EC%9E%90%20%ED%91%9C%EC%8B%9C%20%EA%B0%80%EB%8A%A5%ED%95%A9%EB%8B%88%EB%8B%A4.%22%2C%22link%22%3A%20%7B%20%22web_url%22%3A%20%22https%3A%2F%2Fdevelopers.kakao.com%22%2C%22mobile_web_url%22%3A%20%22https%3A%2F%2Fdevelopers.kakao.com%22%7D%2C%22button_title%22%3A%20%22%EB%B0%94%EB%A1%9C%20%ED%99%95%EC%9D%B8%22%7D"
    
}

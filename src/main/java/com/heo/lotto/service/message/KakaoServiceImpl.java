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
}

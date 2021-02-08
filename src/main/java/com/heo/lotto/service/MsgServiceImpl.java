package com.heo.lotto.service;

import java.net.URI;

import com.heo.lotto.service.message.MessageService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class MsgServiceImpl implements MessageService{


    private RestTemplate restTemplate;

    @Value("${kakao.talk.key}")
    private String KAKAO_TALK_KEY;
    private String url;

    public MsgServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public HttpStatus sendMessage(String msg) {
        // HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String,Object> body = new LinkedMultiValueMap<>();

        JSONObject template_object = new JSONObject();
        
        template_object.put("object_type", "text");
        template_object.put("link", new JSONObject().put("web_url", "https://developers.kakao.com"));
        template_object.put("text", "text msg");
        template_object.put("button_title", "click");

        body.add("template_object", template_object.toString());

        RequestEntity request = RequestEntity
                                .post(URI.create("https://kapi.kakao.com/v2/api/talk/memo/default/send"))
                                .header("Authorization", "Bearer " + KAKAO_TALK_KEY)
                                .accept(MediaType.APPLICATION_FORM_URLENCODED)
                                .body(body);

        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        
        return response.getStatusCode();
    }
    
}

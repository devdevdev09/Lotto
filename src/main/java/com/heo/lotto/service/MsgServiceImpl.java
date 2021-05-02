package com.heo.lotto.service;

import java.net.URI;

import com.heo.lotto.service.message.MessageService;

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
    @Value("${url.msgbot}")
    private String MSG_URL;

    public MsgServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public HttpStatus sendMessage(String msg) {
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        body.add("msg", msg);

        RequestEntity request = RequestEntity
                                    .post(URI.create(MSG_URL))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .body(body);

        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        
        return response.getStatusCode();
    }
    
}

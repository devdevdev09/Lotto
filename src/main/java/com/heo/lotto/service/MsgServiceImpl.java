package com.heo.lotto.service;

import java.net.URI;

import com.heo.lotto.service.message.MessageService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class MsgServiceImpl implements MessageService{


    private RestTemplate restTemplate;

    public MsgServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public HttpStatus sendMessage(String msg) {
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();

        RequestEntity request = RequestEntity
                                    .post(URI.create("localhost:8080/send"))
                                    .accept(MediaType.APPLICATION_JSON)
                                    .body(body);

        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        
        return response.getStatusCode();
    }
    
}

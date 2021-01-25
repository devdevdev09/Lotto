package com.heo.lotto.service.message;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SlackServiceImpl implements MessageService {

    RestTemplate restTemplate;

    @Value("${slack.webhook}")
    public String url;

    public SlackServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean sendMessage(String msg) {
        int status = 0;

        HttpHeaders headers = new HttpHeaders();
        Map<String,Object> body = new HashMap<String, Object>();
        body.put("username", "lotto");
        body.put("text", msg);

        try {
            HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(body, headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    
            status = response.getStatusCodeValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (status == 200) ? true : false;
    }
    
}

package com.heo.lotto.service.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

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

        // Map<String,String> body = new MultivalueHashMap<String,String>();
        String bo = ("template_object={\"object_type\": \"text\",\"text\": \"텍스트 영역입니다. 최대 200자 표시 가능합니다.\",\"link\": { \"web_url\": \"https://developers.kakao.com\",\"mobile_web_url\": \"https://developers.kakao.com\"},\"button_title\": \"바로 확인\"}");

        HttpEntity request = new HttpEntity<>(bo,headers);

        restTemplate.postForObject(SEND_ME_URL, request, Integer.class);


        return false;
    }

    // static class  Template_object{
    //     ObjectMapper mapper = new ObjectMapper();

    //     Map<String, Object> link = new HashMap<String, Object>();
    //     link.put("web_url", "http");
    //     link.put("mobile_web_url", "http");

    //     Map<String, Object> temp = new HashMap<String, Object>();
    //     temp.put("link", link);
    //     temp.put("object_type", "text");
    //     temp.put("text", "test message");
    //     temp.put("button_title", "btn");
    // }
}

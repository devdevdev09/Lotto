package com.heo.lotto.service.lotto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heo.lotto.domain.Lotto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiServiceImpl implements ApiService {

    @Value("${lotto.api.url}")
    private String WIN_API_URL;

    @Override
    public Lotto getLottoByNo(int no) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders header = new HttpHeaders();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(WIN_API_URL + String.valueOf(no), String.class, header);

        ObjectMapper mapper = new ObjectMapper();
        Lotto result = null;

        try {
            result = mapper.readValue(responseEntity.getBody(), Lotto.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }

}

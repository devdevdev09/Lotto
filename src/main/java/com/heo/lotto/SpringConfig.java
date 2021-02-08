package com.heo.lotto;

import com.heo.lotto.service.MsgServiceImpl;
import com.heo.lotto.service.message.MessageService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

    @Bean
    public MessageService slack() {
        return new MsgServiceImpl(new RestTemplate());
    }

    
}

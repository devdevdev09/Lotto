package com.heo.lotto;

import com.heo.lotto.service.message.MessageService;
import com.heo.lotto.service.message.SlackServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfig {

    @Bean
    public MessageService messageService() {
        return new SlackServiceImpl(new RestTemplate());
    }
    
}

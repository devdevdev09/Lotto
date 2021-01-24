package com.heo.lotto.service.message;

import ch.qos.logback.classic.Logger;

public class SlackServiceImpl implements MessageService {

    @Override
    public boolean sendMessage(String msg) {
        System.out.println("test : " + msg);
        return false;
    }
    
}

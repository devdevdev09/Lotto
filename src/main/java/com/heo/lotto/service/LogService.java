package com.heo.lotto.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void info(String log, String path){
        logger.info(path + " : " + log);
    }
    
    public void info(String log){
        logger.info(log);
    }
}

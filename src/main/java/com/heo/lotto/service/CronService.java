package com.heo.lotto.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Scheduled(cron = "0 0 * * * *")
    public void test(){
        logger.info("매시간 0분 0초 출력");
    }
}

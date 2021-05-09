package com.heo.lotto.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final DataService dataService;

    public CronService(DataService dataService){
        this.dataService = dataService;
    }
    
    @Scheduled(cron = "10 */5 21-23 * * SAT")
    public void winCheck(){
        dataService.getWinNumber();
    }

    @Scheduled(cron = "0 0 21 * * 6")
    public void winCheck2(){
        dataService.updateFalse();
    }
}

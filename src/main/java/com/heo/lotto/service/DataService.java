package com.heo.lotto.service;

import com.heo.lotto.domain.Lotto;
import com.heo.lotto.service.lotto.ApiService;
import com.heo.lotto.service.message.MessageService;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    private ApiService apiService;
    private DateService dateService;
    private MessageService slack;
    
    boolean isWinUpdate = false;

    public DataService(DateService dateService, ApiService apiService, MessageService slack){
        this.dateService = dateService;
        this.apiService = apiService;
        this.slack = slack;
    }
    
    public void getWinNumber(){

        int weekNo = dateService.getWeekNo();

        Lotto result = apiService.getLottoByNo(weekNo);
        
        if(!result.getReturnValue().equals("fail") && !isWinUpdate){
            //isWinUpdate = true;
            slack.sendMessage(result.toString());
        }
    }

    public void updateFalse(){
        isWinUpdate = false;
    }
}

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
    
    public void getWinNumber(){

        int weekNo = dateService.getWeekNo();

        Lotto result = apiService.getLottoByNo(weekNo);
        
        if(!result.getReturnValue().equals("success") && !isWinUpdate){
            isWinUpdate = true;
            slack.sendMessage(result.toString());
        }
    }

    public void updateFalse(){
        isWinUpdate = false;
    }
}

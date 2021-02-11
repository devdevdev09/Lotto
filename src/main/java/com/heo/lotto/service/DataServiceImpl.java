package com.heo.lotto.service;

import com.heo.lotto.domain.Lotto;
import com.heo.lotto.service.lotto.ApiService;
import com.heo.lotto.service.message.MessageService;

import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    private ApiService apiService;
    private DateService dateService;
    private MessageService slack;
    
    boolean isWinUpdate = false;

    public DataServiceImpl(DateService dateService, ApiService apiService, MessageService slack){
        this.dateService = dateService;
        this.apiService = apiService;
        this.slack = slack;
    }
    
    @Override
    public void getWinNumber(){

        int weekNo = dateService.getWeekNo();

        Lotto result = apiService.getLottoByNo(weekNo);
        
        if(!result.getReturnValue().equals("fail") && !isWinUpdate){
            //isWinUpdate = true;
            slack.sendMessage(result.toString());
        }
    }
    @Override
    public void updateFalse(){
        isWinUpdate = false;
    }

    @Override
    public boolean save() {
        // TODO Auto-generated method stub
        return false;
    }
}

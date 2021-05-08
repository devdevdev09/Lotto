package com.heo.lotto.service;

import com.heo.lotto.domain.Lotto;
import com.heo.lotto.service.lotto.ApiService;
import com.heo.lotto.service.message.MessageService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {
    private ApiService apiService;
    private DateService dateService;
    private MessageService slack;

    boolean isWinUpdate = false;

    public DataServiceImpl(DateService dateService, ApiService apiService, MessageService slack) {
        this.dateService = dateService;
        this.apiService = apiService;
        this.slack = slack;
    }

    @Override
    @Scheduled(cron = "10 */10 21-23 * * 6")
    public void getWinNumber() {
        int weekNo = dateService.getWeekNo();

        Lotto result = apiService.getLottoByNo(weekNo);

        if (!result.getReturnValue().equals("fail") && !isWinUpdate) {
            isWinUpdate = true;
            slack.sendMessage(result.toString());
        }
    }

    @Override
    @Scheduled(cron = "0 0 21 * * 6")
    public void updateFalse() {
        isWinUpdate = false;
    }

    @Override
    public boolean save() {
        // TODO Auto-generated method stub
        return false;
    }
}

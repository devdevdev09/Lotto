package com.heo.lotto.service;

import org.springframework.stereotype.Service;

@Service
public class DataService {
    // 매주 토요일 9~10시 반복 
    // 그리고 당첨되면 더이상 안함
    boolean isWinUpdate = false;
    public void getWinNumber(){
        if(!isWinUpdate){
            // 업데이트 안되어 있으면 다음번 또 시도

            // 업데이트 되면 보내지 않기
            isWinUpdate = true;

            if(isWinUpdate){
                // send to slack;
            }
        }

    }
}

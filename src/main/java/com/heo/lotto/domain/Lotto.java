package com.heo.lotto.domain;

import lombok.Data;

/**
 * @author heodaewon
 * @since 2021.01
 */
@Data
public class Lotto {

    int drwNo;    // 회차 
    int drwtNo1;  // 당첨번호
    int drwtNo2;
    int drwtNo3;
    int drwtNo4;
    int drwtNo5;
    int drwtNo6;
    int bnusNo;   // 보너스
    int firstPrzwnerCo;  // 당첨인원
    Long totSellamnt;    // 총판매금액
    Long firstWinamnt;   // 1등 인당금액
    Long firstAccumamnt; // 1등 총 당첨금액
    String returnValue;  // 결과
    String drwNoDate;    // 추첨일

    @Override
    public String toString(){
        String result = drwNoDate + " : " + drwNo + " : " + drwtNo1 + "," + drwtNo2 + "," + drwtNo3 + "," + drwtNo4 + "," + drwtNo5 + "," + drwtNo6;
        
        return result;
    }
}


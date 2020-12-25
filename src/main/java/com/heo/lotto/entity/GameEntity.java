package com.heo.lotto.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.Data;

@Repository
@Component
@Data
public class GameEntity {
    /*
    @Repository 와 @Component
     */
    private LocalDateTime date;
    private int week;
    private int no; // 회차
    private int[] number;
    private boolean winning;

    @Override
    public String toString(){
        return "";
    }

    public String numberToString(){
        String numbers = "";
        for(int num : number){
            numbers +=  "[" + String.format("%02d", num) + "]";
        }

        return numbers;
    }
}

package com.heo.lotto.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class DateService {
    public LocalDate getToday(){
        LocalDate date = LocalDate.now();
        
        return date;
    }

    public String getAddDay(int add){
        LocalDate date = getToday().plusDays(add);
        
        return date.toString();
    }

    public String getTime(){
        LocalDateTime time = LocalDateTime.now();

        return format(time.getHour()) + ":" + format(time.getMinute())  + ":" + format(time.getSecond());
    }

    public String todayTime(){
        return getToday() + " " + getTime() + " ";
    }

    public String format(int time){
        return String.format("%02d", time);
    }
}

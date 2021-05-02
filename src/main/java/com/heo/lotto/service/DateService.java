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

    public int getWeekNo(){
        String BASE_DATE = "2021-01-23";
        int BASE_NO = 947;

        String[] date = BASE_DATE.split("-");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        
        LocalDate date1 = LocalDate.of(year,month,day);
        LocalDate date2 = LocalDate.now();
    
        
        int d1 = date1.getDayOfYear();
        int d2 = date2.getDayOfYear();

        return BASE_NO + (d2-d1)/7;
    }
}


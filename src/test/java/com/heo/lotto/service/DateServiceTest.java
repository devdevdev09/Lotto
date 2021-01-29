package com.heo.lotto.service;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DateServiceTest {
    
    @Test
    public void 회차_계산(){
        DateService ds = new DateService();
        System.out.println(ds.getWeekNo());
    }
}

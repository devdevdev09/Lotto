package com.heo.lotto.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class GameEntity {
    /*
    @Repository 와 @Component
     */
    private LocalDateTime date;
    private int week;
    private int cnt; // 회차
    private int[] number;
}

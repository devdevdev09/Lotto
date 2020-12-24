package com.heo.lotto.service;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    
    public boolean isWinning(int[] target, int[] input){
        return target.equals(input);
    }

    public int[] getWinNumberByWeek(int week){
        return null;
    }
}

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

    // 몇개의 숫자가 맞았는지 체크
    public int equalsNumberCount(int[] target, int[] input){
        return 0;
    }
}

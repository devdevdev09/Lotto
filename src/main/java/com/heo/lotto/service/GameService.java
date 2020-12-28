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
    // 개수로 1,3,4,5 등을 체크한다.
    public int equalsNumberCount(int[] target, int[] input){
        int cnt = 0;

        for(int num1 : target){
            for(int num2 : input){
                if(num1 == num2){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // 2등 체크
    public boolean is2ndWin(int[] target, int[] input, int bonus){
        return true;
    }
}

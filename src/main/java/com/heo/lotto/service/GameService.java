package com.heo.lotto.service;

import java.util.Arrays;
import java.util.List;

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
    public int equalsNumberCount(int[] target, int[] input, int bonus){
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

    // 등수 체크
    public int isWinRank(int[] target, int[] input, int bonus){
        int cnt = equalsNumberCount(target, input, bonus);
        
        if(cnt == 6) return 1;
        if(cnt == 5) 
            if(is2ndWin(target, input, bonus))
                return 2;
            else 
                return 3;
        if(cnt == 4) return 4;
        if(cnt == 3) return 5;

        return 0;
    }

    // 2등 체크
    public boolean is2ndWin(int[] target, int[] input, int bonus){
        List<Object> result = Arrays.asList(input);
        int cnt = 0;

        for(int num1 : target){
            for(Object num2 : result){
                if(num1 == (int)num2){
                    cnt++;
                }
            }
        }

        if(cnt == 6)
            return true;
        else
            return false;
    }
}

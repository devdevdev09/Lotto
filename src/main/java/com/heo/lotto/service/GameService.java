package com.heo.lotto.service;

import java.util.Arrays;
import java.util.List;

import com.heo.lotto.entity.RankType;

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
        
        if(cnt == RankType.FIRST.getRequireCnt()) 
            return RankType.FIRST.getRank();
            
        if(cnt == RankType.THIRD.getRequireCnt()) 
            if(is2ndWin(target, input, bonus))
                return RankType.SECOND.getRank();
            else 
                return RankType.THIRD.getRank();

        if(cnt == RankType.FOURTH.getRequireCnt()) 
            return RankType.FOURTH.getRank();

        if(cnt == RankType.FIFTH.getRequireCnt()) 
                    return RankType.FIFTH.getRank();

        return RankType.LOSE.getRank();
    }

    // 2등 체크
    public boolean is2ndWin(int[] target, int[] input, int bonus){
        // List<Object> result = Arrays.asList(input);
        int cnt = 0;
        int[] result = new int[target.length + 1];

        int i = 0;
        for(int num : target){
            result[i++] = num;
        }

        result[target.length] = bonus;

        for(int num1 : result){
            for(int num2 : input){
                if(num1 == num2){
                    cnt++;
                }
            }
        }

        if(cnt == RankType.FIRST.getRequireCnt())
            return true;
        else
            return false;
    }

    // 회차별 상금 가져오기
    public int[] getPriceByWeek(int week){
        return null;
    }


    // 회차별 등수별 상금 가져오기
    public int getRankPriceByWeek(int week, int rank){
        return 0;
    }
}

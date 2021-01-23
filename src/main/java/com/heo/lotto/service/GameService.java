package com.heo.lotto.service;

import org.springframework.stereotype.Service;

@Service
public interface GameService {
    
    public boolean isWinning(int[] target, int[] input);

    public int[] getWinNumberByWeek(int week);

    // 몇개의 숫자가 맞았는지 체크
    // 개수로 1,3,4,5 등을 체크한다.
    public int equalsNumberCount(int[] target, int[] input, int bonus);

    // 등수 체크
    public int isWinRank(int[] target, int[] input, int bonus);

    // 2등 체크
    public boolean is2ndWin(int[] target, int[] input, int bonus);

    // 회차별 상금 가져오기
    public int[] getPriceByWeek(int week);


    // 회차별 등수별 상금 가져오기
    public int getRankPriceByWeek(int week, int rank);

    public double winningMoney(int rank, double[] moneys);
}

package com.heo.lotto.domain;

public enum RankType {
    FIRST(1,6),SECOND(2,6),THIRD(3,5),FOURTH(4,4),FIFTH(5,3),LOSE(0,0);
    
    private int rank;
    private int requireCnt;
    
    RankType(int rank, int requireCnt){
        this.rank = rank;
        this.requireCnt = requireCnt;
    }

    public int getRank(){
        return rank;
    }

    public int getRequireCnt(){
        return requireCnt;
    };
}

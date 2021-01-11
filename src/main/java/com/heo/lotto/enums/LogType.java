package com.heo.lotto.enums;

public enum LogType {
    GAME("GAME", "외부요청에 의해서 만들어진다"),
    BATCH("BATCH", "스케줄링에 의해서 만들어진다");

    private String code;
    private String desc;
    
    LogType(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}

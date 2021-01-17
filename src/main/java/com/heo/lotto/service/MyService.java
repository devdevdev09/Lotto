package com.heo.lotto.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    // 나만 쓸수 있게 당첨자 번호 등록하기
    // 기존 가생성 번호와 같이 체크하기
    private final FileService fileService;
    private final DateService dateService;

    @Value("${str.divider}")
    private String STR_DIVIDER;
    
    @Value("${data.path.mynumber}")
    private String MY_NUMBER_PATH;

    public MyService(FileService fileService, DateService dateService){
        this.fileService = fileService;
        this.dateService = dateService;
    }

    public void writeMyNumber(String content){
        fileService.writeFile(content, MY_NUMBER_PATH);
    }

    public void writeArr(int[] arr){
        String content = getNumberString(arr);
        String time = dateService.todayTime();

        fileService.writeFile(time + STR_DIVIDER + content, MY_NUMBER_PATH);
    }

    public String getNumberString(int[] arr){
        String content = "";

        for(int num : arr){
            content += String.valueOf(num) + ",";
        }

        String result = content.substring(0, content.length()-1) ;

        return result;
    }
}

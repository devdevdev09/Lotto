package com.heo.lotto.service;

import org.springframework.stereotype.Service;

@Service
public class FileService {
    public String getFileRead(String filePath){
        return "";
    }

    public int[][] parseNumbers(){
        return null;
    }

    public int[] getNumber(){
        return null;
    }

    // 9982 : [02][05][12][15][32][39]
    public String[] splitGameNumber(String str){
        String[] result = str.split(" : ");
        return result;
    }

    // 9982 : [02][05][12][15][32][39]
    public String getReplaceStr(String str){
        String result = str.replace("][", ",").replace("[", "").replace("]", "");
        return result;
    }


}

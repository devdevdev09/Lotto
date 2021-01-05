package com.heo.lotto.service;

import org.springframework.stereotype.Service;

@Service
public class FileService {
    final String STR_DIVIDER = " : ";

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
        String[] result = str.split(STR_DIVIDER);
        
        return result;
    }

    // 9982 : [02][05][12][15][32][39]
    public String getReplaceStr(String str){
        String result = str.replace("][", ",").replace("[", "").replace("]", "");

        return result;
    }
    
    public String[] splitRow(String str){
        String[] result = new String[2];
        result[0] = str.split(STR_DIVIDER)[2];
        result[1] = str.split(STR_DIVIDER)[3];

        return result;
    }


}

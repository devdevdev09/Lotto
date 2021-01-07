package com.heo.lotto.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    final String STR_DIVIDER = " : ";

    public List<String> getFileRead(String filePath) {
        ClassPathResource resource = new ClassPathResource(filePath);
        List<String> content = new ArrayList<String>();

        Path path;
        try {
            path = Paths.get(resource.getURI());
            content = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public int getLineCount(){
        return 0;
    }

    public int[][] parseNumbers(){
        return null;
    }

    public int[] getNumber(){
        return null;
    }

    public boolean isLogData(String log){
        String[] arr = log.split(STR_DIVIDER);

        return arr.length == 4;
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

    // 12,17,25,37,39,40   
    public int[] logToNum(String log){
        String[] str = log.split(",");
        
        return Arrays.stream(str).mapToInt(s->Integer.parseInt(s)).toArray();
    }


}

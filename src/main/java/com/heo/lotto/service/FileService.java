package com.heo.lotto.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    final String STR_DIVIDER = " : ";

    public String getFileRead(String filePath) {
        ClassPathResource resource = new ClassPathResource(filePath);

        Path path;
        try {
            path = Paths.get(resource.getURI());
            List<String> content = Files.readAllLines(path);
            System.out.println(content.size());
            content.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

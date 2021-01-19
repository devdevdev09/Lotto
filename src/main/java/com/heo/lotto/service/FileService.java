package com.heo.lotto.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.heo.lotto.enums.LogType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${str.divider}")
    private String STR_DIVIDER;
    
    private DateService dateService;

    public FileService(DateService dateService){
        this.dateService = dateService;
    }

    public List<String> getFileRead(String filePath) {
        List<String> content = new ArrayList<String>();

        Path path = Paths.get("/data/lotto/2020-01-08.log");
        try {
            //path = Paths.get(resource.getURI());
            content = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public String getDate(){
        LocalDate date = LocalDate.now().plusDays(-1);
        
        return date.toString();
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

    public String[] splitGameNumber(String str){
        String[] result = str.split(STR_DIVIDER);
        
        return result;
    }

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

    public int[] logToNum(String log){
        String[] str = log.split(",");
        
        return Arrays.stream(str).mapToInt(s->Integer.parseInt(s)).toArray();
    }

    public void writeLog(String log, LogType type){
        String today = dateService.getToday().toString();

        writeFile(dateService.todayTime() + STR_DIVIDER + "게임번호" + STR_DIVIDER + type + STR_DIVIDER + log + "\n"
            ,"/logs/data-" + today + ".txt");
        
    }

    public void writeFile(String content, String path){
        File file = new File(path);
        
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileWriter fw;
        try {
            fw = new FileWriter(file.getAbsolutePath(), true);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.append(content + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getGameNo(){
        String no = dateService.getToday() + dateService.getTime();
    
        return no.replaceAll("[^0-9]", "");
    }

    public String getUUID(){
        UUID uuid = UUID.randomUUID();
        
        return uuid.toString();
    }

}

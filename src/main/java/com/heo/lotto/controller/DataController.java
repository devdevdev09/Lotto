package com.heo.lotto.controller;

import com.heo.lotto.domain.Lotto;
import com.heo.lotto.service.DataService;
import com.heo.lotto.service.FileService;
import com.heo.lotto.service.GameService;
import com.heo.lotto.service.lotto.ApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {
    private FileService fileService;
    private GameService gameService;
    private ApiService apiService;
    private final DataService dataService;


    @Autowired
    public DataController(FileService fileService, GameService gameService, ApiService apiService, DataService dataService) {
        this.fileService = fileService;
        this.gameService = gameService;
        this.apiService = apiService;
        this.dataService = dataService;
    }

    @GetMapping("/win/{num}")
    public ResponseEntity<Lotto> getWinNumber(@PathVariable(required = false) Integer num) {
        Lotto result = apiService.getLottoByNo(num);
        
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/win/lotto")
    public void getWin(){
        dataService.getWinNumber();
    }
    
    @GetMapping("/read/log")
    public void getLogDate(){
        // List<String> content = fileService.getFileRead("files/test.txt");
        // int first = 0;
        // int second = 0;
        // int third = 0;
        // int fourth = 0;
        // int fifth = 0;
        // int lose = 0;

        // for(String str : content){
        //     if(fileService.isLogData(str)){
        //         String[] log = fileService.splitRow(str);
        //         String numbers = fileService.getReplaceStr(log[1]);
        //         int[] num = fileService.logToNum(numbers);

        //         int result = gameService.isWinRank(target, num, bonus);

        //         if(result == 1) first++;
        //         if(result == 2) second++;
        //         if(result == 3) third++;
        //         if(result == 4) fourth++;
        //         if(result == 5) fifth++;
        //         if(result == 0) lose++;
        //     }
        // }

        // System.err.println("1 : " + first);
        // System.err.println("2 : " + second);
        // System.err.println("3 : " + third);
        // System.err.println("4 : " + fourth);
        // System.err.println("5 : " + fifth);
        // System.err.println("X : " + lose);

        // DecimalFormat formatter = new DecimalFormat("###,###,###,###,###");
        // System.out.println("==============total============");
        // int cnt = first + second + third + fourth + fifth + lose;
        // double tot = first*moneys[0] + second* moneys[1] + third*moneys[2] + fourth*moneys[3] + fifth*moneys[4];
        // int payed = cnt*1000;
        // System.out.println("게임 : " + formatter.format(cnt) + "게임");
        // System.out.println("구매 : " + formatter.format(payed) + "원");
        // System.out.println("당첨 : " + formatter.format(tot) + "원");

    }

}

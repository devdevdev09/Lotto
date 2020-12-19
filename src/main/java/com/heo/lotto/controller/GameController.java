package com.heo.lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.heo.lotto.entity.GameEntity;
import com.heo.lotto.service.NumberService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    final int LOTTO_BALL_COUNT = 6;

    private NumberService numberSerivce;

    public GameController(NumberService numberService){
        this.numberSerivce = numberService;
    }

    @RequestMapping(value ={ "/create/game", "/create/game/{cnt}"})
    public List<int[]> createGame(@PathVariable(required = false) Integer cnt){
        if(cnt == null){
            cnt = 1;
        }

        List<int[]> list = new ArrayList<int[]>();

        for(int i = 0; i < cnt; i++){
            list.add(numberSerivce.getNumber(LOTTO_BALL_COUNT));
        }

        return list;
    }

    @RequestMapping("/TEST")
    public ResponseEntity<List<GameEntity>> createGame(){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/makeLog")
    public void makeLog(){
        for(int i = 0; i < 10000; i++){
            int[] arr = numberSerivce.getNumber(LOTTO_BALL_COUNT);
            logger.info(i + " : " + Arrays.stream(arr).mapToObj(s->String.valueOf(s)).collect(Collectors.joining(",")));
        }
    }
    
}

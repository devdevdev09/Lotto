package com.heo.lotto.controller;

import java.util.ArrayList;
import java.util.List;

import com.heo.lotto.service.NumberService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

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
    
}

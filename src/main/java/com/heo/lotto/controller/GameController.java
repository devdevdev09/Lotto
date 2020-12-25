package com.heo.lotto.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import com.heo.lotto.entity.GameEntity;
import com.heo.lotto.service.GameService;
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
    private GameService gameService;

    public GameController(NumberService numberService, GameService gameService){
        this.numberSerivce = numberService;
        this.gameService = gameService;
    }

    @RequestMapping(value ={ "/create/game", "/create/game/{cnt}"})
    public ResponseEntity<List<GameEntity>> createGame(@PathVariable(required = false) Integer cnt){
        if(cnt == null){
            cnt = 1;
        }

        List<GameEntity> result = new ArrayList<GameEntity>();
        int[] target = {1,2,3,4,5,6};

        logger.info("CREATE GAME START\n");
        for(int i = 0; i < cnt; i++){
            GameEntity game = setEntity(i+1);
            
            boolean isWinning = gameService.isWinning(target, game.getNumber());
            game.setWinning(isWinning);

            result.add(game);
        }
        logger.info("CREATE GAME END\n");

        return new ResponseEntity<List<GameEntity>>(result, HttpStatus.OK);
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

    public GameEntity setEntity(int count){
        // 2020-12-19 > 942회

        GameEntity entity = new GameEntity();
        entity.setDate(LocalDateTime.now());
        entity.setNumber(numberSerivce.getNumber(LOTTO_BALL_COUNT));
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        entity.setWeek(LocalDateTime.now().get(weekFields.weekOfYear()));
        entity.setNo(950);
        entity.setWinning(true);

        logger.info("CREATE GAME NUMBER : " + count + " : " + entity.numberToString());

        return entity;
    }
    
}

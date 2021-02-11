package com.heo.lotto.controller;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import com.heo.lotto.domain.Game;
import com.heo.lotto.enums.LogType;
import com.heo.lotto.service.FileService;
import com.heo.lotto.service.GameService;
import com.heo.lotto.service.NumberService;
import com.heo.lotto.service.message.MessageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    final int LOTTO_BALL_COUNT = 6;

    private final NumberService numberSerivce;
    private final GameService gameService;
    private final FileService fileService;
    private final MessageService slack22;

    public GameController(NumberService numberService, GameService gameService, FileService fileService, MessageService slack22){
        this.numberSerivce = numberService;
        this.gameService = gameService;
        this.fileService = fileService;
        this.slack22 = slack22;
    }

    @RequestMapping(value ={ "/create/game", "/create/game/{cnt}"})
    public ResponseEntity<List<Game>> createGame(@PathVariable(required = false) Integer cnt){
        if(cnt == null){
            cnt = 1;
        }

        List<Game> result = new ArrayList<Game>();
        int[] target = {1,2,3,4,5,6};

        logger.info("CREATE GAME START\n");
        for(int i = 0; i < cnt; i++){
            Game game = setEntity(i+1);
            
            boolean isWinning = gameService.isWinning(target, game.getNumber());
            game.setWinning(isWinning);

            result.add(game);
        }
        logger.info("CREATE GAME END\n");

        return new ResponseEntity<List<Game>>(result, HttpStatus.OK);
    }

    @RequestMapping("/TEST")
    public ResponseEntity<List<Game>> createGame(){
        slack22.sendMessage("testttt");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping("/makeLog")
    public void makeLog(){
        for(int i = 0; i < 10000; i++){
            int[] arr = numberSerivce.getNumber(LOTTO_BALL_COUNT);
            logger.info(i + " : " + Arrays.stream(arr).mapToObj(s->String.valueOf(s)).collect(Collectors.joining(",")));
        }
    }

    public Game setEntity(int count){
        Game entity = new Game();
        entity.setDate(LocalDateTime.now());
        entity.setNumber(numberSerivce.getNumber(LOTTO_BALL_COUNT));
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        entity.setWeek(LocalDateTime.now().get(weekFields.weekOfYear()));
        entity.setNo(950);
        entity.setWinning(true);

        fileService.writeLog("CREATE GAME NUMBER : " + count + " : " + entity.numberToString(), LogType.GAME);

        return entity;
    }

    @PostMapping("/lotto")
    public <T> ResponseEntity<T> lotto(
        @RequestBody(required = false) Map<String,Object> param) {

            System.out.println(param);
        if(param != null){
            if(param.get("key").equals("heo")){
                System.out.println("인증");
                Map<String,Object> data = (Map<String,Object>)param.get("data");
                List<Integer> numbers = (List<Integer>)data.get("numbers");
                System.out.println();
            }else{
                System.out.println("실패");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

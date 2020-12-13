package com.heo.lotto.controller;

import java.util.Optional;

import com.heo.lotto.service.NumberService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    NumberService numberService;

    public MainController(NumberService numberService){
        this.numberService = numberService;
    }

    @GetMapping(value = {"/", "/lotto", "/lotto/{cnt}"})
    public int[] getLotto(@PathVariable(required = false) Integer cnt){
        if(cnt == null) 
            cnt = 6;
            
        if(cnt > 6) cnt = 6;
        if(cnt < 0) cnt = 1;

        int[] arr = new int[cnt];
        arr = numberService.getNumber(cnt);

        return arr;
    }

    @GetMapping(value = {"/lotto2", "/lotto2/{cnt}"})
    public int[] getLotto2(@PathVariable(required = false) Optional<Integer> cnt){
        int cnt2 = cnt.orElse(6);
        
        if(cnt2 > 6) cnt2 = 6;
        if(cnt2 < 0) cnt2 = 1;

        int[] arr = new int[cnt2];
        arr = numberService.getNumber(cnt2);

        return arr;
    }
}

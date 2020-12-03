package com.heo.lotto.controller;

import java.util.Optional;

import com.heo.lotto.service.NumberService;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    NumberService numberService;

    public MainController(NumberService numberService){
        this.numberService = numberService;
    }

    @GetMapping(value = {"/", "/lotto", "/lotto/{cnt}"})
    public int[] getLotto(@PathVariable Optional<Integer> cnt){
        int num = cnt.isPresent() ? cnt.get() : 6;

        if(num > 6) num = 6;
        if(num < 0) num = 1;

        int[] arr = new int[num];
        arr = numberService.getNumber(num);

        return arr;
    }
}

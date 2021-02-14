package com.heo.lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NumberServiceImpl implements NumberService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    final int MAX_COUNT = 45;

    public int[] getNumber(int cnt){
        List<Integer> list = initList(MAX_COUNT);
        List<Integer> result = new ArrayList<Integer>();

        while(result.size() < cnt){
            int num = new Random().nextInt(list.size());
            result.add(list.get(num));
            list.remove(list.get(num));
        }

        int[] lotto = result.stream().mapToInt(i->i).sorted().toArray();

        return lotto;
    }

    public List<Integer> initList(int max){

        List<Integer> list = new ArrayList<Integer>();

        for(int i = 1 ; i <= max; i++){
            list.add(i);
        }

        return list;
    }   
}

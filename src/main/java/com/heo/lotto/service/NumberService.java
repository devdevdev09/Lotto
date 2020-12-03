package com.heo.lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NumberService {
    
    public int[] getNumber(int cnt){
        List<Integer> list = new ArrayList<Integer>();
 

        while(list.size() < cnt){
            int num = new Random().nextInt(45)+1;
            
            if(!list.contains(num)){
                list.add(num);
            }
        }

        return  list.stream().mapToInt(i->i).sorted().toArray();
    }
}

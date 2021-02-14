package com.heo.lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public interface NumberService {
    public int[] getNumber(int cnt);

    public List<Integer> initList(int max);
}

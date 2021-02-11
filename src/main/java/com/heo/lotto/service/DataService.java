package com.heo.lotto.service;

import org.springframework.stereotype.Service;

@Service
public interface DataService {
    
    public void getWinNumber();

    public void updateFalse();

    public boolean save();
}

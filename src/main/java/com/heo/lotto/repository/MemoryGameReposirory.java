package com.heo.lotto.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.heo.lotto.entity.Game;

public class MemoryGameReposirory implements GameRepository {

    private static Map<Long, Game> store = new HashMap<Long, Game>();
    private static long sequence = 0L;

    @Override
    public Game save(Game game) {
        store.put(++sequence, game);
        
        return game;
    }

    @Override
    public Optional<Game> findById(Long id) {
        
        return Optional.ofNullable(store.get(id));
    }
    
}

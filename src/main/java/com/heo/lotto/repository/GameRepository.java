package com.heo.lotto.repository;

import java.util.Optional;

import com.heo.lotto.domain.Game;

public interface GameRepository {
    Game save(Game game);
    Optional<Game> findById(Long no);
}

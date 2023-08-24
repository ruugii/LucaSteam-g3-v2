package com.LucaSteam.service;

import com.LucaSteam.model.Game;

import java.util.List;

public interface GameService {
    public void save(Game g);

    List<Game> findAll();

    Game findByName(String name);
}

package com.LucaSteam.service;

import com.LucaSteam.model.DTO.GameDTO;
import com.LucaSteam.model.Game;

import java.util.List;

public interface GameService {
    public void save(Game g);
    public Game update(Game g);
    List<GameDTO> findAll();
    Game findByName(String name);
    Game findById(long id);
	void deleteById(long id);
}

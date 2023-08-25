package com.LucaSteam.service;

import com.LucaSteam.model.DTO.GameDTO;
import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GameService {
    public void save(Game g);
    public Game update(Game g);
    List<GameDTO> findAll();
    Game findByName(String name);
    Optional<Game> findById(long id);
	void deleteById(long id);
	List<GameDTO> findAllByGenre(Genre genre);
}

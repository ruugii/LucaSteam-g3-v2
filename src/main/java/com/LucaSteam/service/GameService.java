package com.LucaSteam.service;

import java.util.List;
import java.util.Optional;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Platform;
import com.LucaSteam.repository.DTOGames;

public interface GameService {
	
	public List<Game> findAll();
	
	public void save(Game game);
	
	public Optional<Game> update(Game game);
	
	public Optional<Game> findById(int id);
	
	public void deleteById(int id);

	public List<DTOGames> findAllDTOGames();
}

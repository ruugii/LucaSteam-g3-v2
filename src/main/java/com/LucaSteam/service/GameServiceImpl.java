package com.LucaSteam.service;

import java.util.List;
import java.util.Optional;

import com.LucaSteam.model.Game;
import com.LucaSteam.repository.GameRepository;

public class GameServiceImpl implements GameService{
	
	private GameRepository gameRepo;

	@Override
	public List<Game> findAll() {
		return gameRepo.findAll();
	}

	@Override
	public void save(Game game) {
		gameRepo.save(game);
	}

	@Override
	public Optional<Game> update(Game game) {
		return gameRepo.update(game);
	}

	@Override
	public Optional<Game> findById(int id) {
		return gameRepo.findById(id);
	}

	@Override
	public void deleteById(int id) {
		gameRepo.deleteById(id);
	}

}

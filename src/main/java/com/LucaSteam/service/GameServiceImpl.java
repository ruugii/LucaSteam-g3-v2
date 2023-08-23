package com.LucaSteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Platform;
import com.LucaSteam.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService{
	
	@Autowired
	private GameRepository gameRepo;

	@Override
	public List<Game> findAll() {
		return gameRepo.findAll();
	}
	
	@Override
	public List<DTOGames> findAllDTOGames() {
		return gameRepo.findAllDTOGames();
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

	@Override
	public Optional<Platform> findByPlatform(Platform platform) {
		return gameRepo.findByPlatform(platform);
	}

}

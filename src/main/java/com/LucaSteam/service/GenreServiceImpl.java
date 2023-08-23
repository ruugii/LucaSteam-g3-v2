package com.LucaSteam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.model.Genre;
import com.LucaSteam.repository.GameRepository;

@Service
public class GenreServiceImpl implements GenreService{
	
	@Autowired
	private GameRepository gameRepo;

	@Override
	public Optional<Genre> findByName(Genre genre) {
		return gameRepo.findByName(genre);
	}

}

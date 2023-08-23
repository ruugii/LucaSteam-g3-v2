package com.LucaSteam.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;
import com.LucaSteam.model.Platform;
import com.LucaSteam.repository.GameRepository;

@Service
public class GenreServiceImpl implements GenreService{
	
	@Autowired
	private GameRepository gameRepo;

	@Override
	public String findGenreByName(String genre_name) {
		return gameRepo.findGenreByName(genre_name);
	}
	
	

}

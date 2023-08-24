package com.LucaSteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;
import com.LucaSteam.model.Platform;
import com.LucaSteam.repository.GameRepository;
import com.LucaSteam.model.Genre;
import com.LucaSteam.repository.GenreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDAO genreDAO;

	@Override
	public String findGenreByName(String genre_name) {
		return gameRepo.findGenreByName(genre_name);
	}
	
	

    @Override
    public void save(Genre g) {
        genreDAO.save(g);
    }

    @Override
    public Genre findByName(String name) {
        return genreDAO.findByName(name);
    }
}

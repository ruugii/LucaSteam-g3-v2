package com.LucaSteam.service;

import java.util.Optional;

import com.LucaSteam.model.Genre;

public interface GenreService {
	
	public Optional<Genre> findByName(Genre genre);

}

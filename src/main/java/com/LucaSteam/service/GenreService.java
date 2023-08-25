package com.LucaSteam.service;

import com.LucaSteam.model.Genre;

import org.springframework.stereotype.Service;

public interface GenreService {

    public void save(Genre g);

    public Genre findByName(String name);
   
}

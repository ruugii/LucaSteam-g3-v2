package com.LucaSteam.service;

import com.LucaSteam.model.Genre;
import com.LucaSteam.repository.GenreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDAO genreDAO;

    @Override
    public void save(Genre g) {
        genreDAO.save(g);
    }

    @Override
    public Genre findByName(String name) {
        return genreDAO.findByName(name);
    }
}

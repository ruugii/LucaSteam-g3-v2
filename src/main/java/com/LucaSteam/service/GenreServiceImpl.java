package com.LucaSteam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;
import com.LucaSteam.model.Platform;

import com.LucaSteam.repository.GenreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreDAO genreDAO;

    /**
     * Saves a Genre in the database.
     *
     * @param g The Genre to be saved.
     */
    @Override
    public void save(Genre g) {
        genreDAO.save(g);
    }

    
    /**
     * Searches for a genre by its name in the database.
     *
     * @param name The name of the Genre to search for.
     * @return The found Genre or null if not found.
     */
    @Override
    public Genre findByName(String name) {
        return genreDAO.findByName(name);
    }

}

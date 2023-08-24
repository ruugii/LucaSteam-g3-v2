package com.LucaSteam.service;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;
import com.LucaSteam.model.Platform;
import org.springframework.stereotype.Service;

public interface GenreService {

    public void save(Genre g);

    public Genre findByName(String name);
}

package com.LucaSteam.service;

import com.LucaSteam.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.repository.GameDAO;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    private GameDAO gameDAO;
    @Override
    public void save(Game g) {
        gameDAO.save(g);
    }

    @Override
    public Game update(Game g) {
        return gameDAO.save(g);
    }

    @Override
    public List<Game> findAll() {
        return gameDAO.findAll();
    }

    @Override
    public Game findByName(String name) {
        return gameDAO.findByName(name);
    }

    @Override
    public Game findById(long id) {
        return gameDAO.findById(id);
    }
}

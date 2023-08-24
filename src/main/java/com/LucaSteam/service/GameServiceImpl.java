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
    
    /**
     * Saves a game in the database.
     *
     * @param g The game to be saved.
     */
    @Override
    public void save(Game g) {
        gameDAO.save(g);
    }

    @Override
    public Game update(Game g) {
        return gameDAO.save(g);
    }

    
    
    /**
     * Retrieves all games from the database.
     *
     * @return A list of all games.
     */
    @Override
    public List<Game> findAll() {
        return gameDAO.findAll();
    }

    
    /**
     * Searches for a game by its name in the database.
     *
     * @param name The name of the game to search for.
     * @return The found game or null if not found.
     */
    @Override
    public Game findByName(String name) {
        return gameDAO.findByName(name);
    }

    @Override
    public Game findById(long id) {
        return gameDAO.findById(id);
    }

	@Override
	public void deleteById(long id) {
		gameDAO.deleteById(id);
	}

}

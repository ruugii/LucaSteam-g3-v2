package com.LucaSteam.service;

import com.LucaSteam.model.DTO.GameDTO;
import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.repository.GameDAO;

import java.util.ArrayList;
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
    public List<GameDTO> findAll() {
        List<Game> games = gameDAO.findAll();
        List<GameDTO> gamesDTO = new ArrayList<GameDTO>();
        for (Game game : games) {
            GameDTO aux = new GameDTO();
            aux.setId(game.getId());
            aux.setName(game.getName());
            aux.setYear(game.getYear());
            aux.setSales(game.getSales());
            aux.setPlatform(game.getPlatformId().getName());
            aux.setGenre(game.getGenreId().getName());
            aux.setPublisher(game.getPublisherId().getName());
            gamesDTO.add(aux);
        }
        return gamesDTO;
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

    
    /**
     * Searches for a game by its ID in the database.
     *
     * @param id The ID of the game to search for.
     * @return The found game or null if not found.
     */
    @Override
    public Game findById(long id) {
        return gameDAO.findById(id);
    }

    /**
     * Deletes a game by its ID from the database.
     *
     * @param id The ID of the game to delete.
     */
	@Override
	public void deleteById(long id) {
		gameDAO.deleteById(id);
	}

    @Override
    public List<GameDTO> findAllByGenre(Genre genre) {
        List<Game> games = gameDAO.findAllBygenreId(genre);
        List<GameDTO> gamesDTO = new ArrayList<GameDTO>();
        for (Game game : games) {
            GameDTO aux = new GameDTO();
            aux.setId(game.getId());
            aux.setName(game.getName());
            aux.setYear(game.getYear());
            aux.setSales(game.getSales());
            aux.setPlatform(game.getPlatformId().getName());
            aux.setGenre(game.getGenreId().getName());
            aux.setPublisher(game.getPublisherId().getName());
            gamesDTO.add(aux);
        }
        return gamesDTO;
    }


}

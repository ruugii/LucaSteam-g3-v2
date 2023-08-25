package com.LucaSteam.repository;

import com.LucaSteam.model.Game;

import java.util.List;
import java.util.Optional;

import com.LucaSteam.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Game entities in the database.
 */
@Repository
public interface GameDAO extends JpaRepository<Game, Long> {
	/**
     * Retrieves a game by its name.
     *
     * @param name The name of the game to retrieve.
     * @return The game with the given name or null if not found.
     */
    Game findByName(String name);
    
    /**
     * Retrieves a game from the database by its ID.
     *
     * @param id The ID of the game to retrieve.
     * @return The game with the given ID or null if not found.
     */
    Optional<Game> findById(long id);

    List<Game> findAllBygenreId(Genre genre);
}

package com.LucaSteam.repository;

import com.LucaSteam.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
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
    Game findById(long id);
}

package com.LucaSteam.repository;

import com.LucaSteam.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Genre entities in the database.
 */
@Repository
public interface GenreDAO extends JpaRepository<Genre, Long> {
	
	/**
     * Retrieves a genre by its name.
     *
     * @param name The name of the genre to retrieve.
     * @return The genre with the given name or null if not found.
     */
    @Query("FROM Genre WHERE genre_name =?1")
    Genre findByName(String name);
}

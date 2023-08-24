package com.LucaSteam.repository;

import com.LucaSteam.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Platform entities in the database.
 */
@Repository
public interface PlatformDAO extends JpaRepository<Platform,Long> {
	
	/**
     * Retrieves a Platform by its name.
     *
     * @param name The name of the Platform to retrieve.
     * @return The Platform with the given name or null if not found.
     */
    @Query("FROM Platform WHERE platform_name =?1")
    Platform findByName(String name);
}

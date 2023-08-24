package com.LucaSteam.repository;

import com.LucaSteam.model.Platform;
import com.LucaSteam.model.Publisher;
import com.LucaSteam.service.PublisherServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing Publisher entities in the database.
 */
@Repository
public interface PublisherDAO extends JpaRepository<Publisher, Long> {
	
	/**
     * Retrieves a Publisher by its name.
     *
     * @param name The name of the Publisher to retrieve.
     * @return The Publisher with the given name or null if not found.
     */
    @Query("FROM Publisher WHERE publisher_name =?1")
    Publisher findByName(String name);
}

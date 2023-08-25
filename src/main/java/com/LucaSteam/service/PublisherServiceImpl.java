package com.LucaSteam.service;

import com.LucaSteam.model.Platform;
import com.LucaSteam.model.Publisher;
import com.LucaSteam.repository.PlatformDAO;
import com.LucaSteam.repository.PublisherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherDAO publisherDAO;
    
    /**
     * Saves a Publisher in the database.
     *
     * @param g The Publisher to be saved.
     */
    @Override
    public void save(Publisher p) {
        publisherDAO.save(p);
    }

    
    /**
     * Searches for a Publisher by its name in the database.
     *
     * @param name The name of the Publisher to search for.
     * @return The found Publisher or null if not found.
     */
    @Override
    public Publisher findByName(String name) {
        return publisherDAO.findByName(name);
    }
}

package com.LucaSteam.service;

import com.LucaSteam.model.Platform;
import com.LucaSteam.repository.GameDAO;
import com.LucaSteam.repository.PlatformDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformServiceImpl implements PlatformService {

    @Autowired
    private PlatformDAO platformDAO;
    
    /**
     * Saves a Platform in the database.
     *
     * @param g The Platform to be saved.
     */
    @Override
    public void save(Platform p) {
        platformDAO.save(p);
    }

    
    /**
     * Searches for a Platform by its name in the database.
     *
     * @param name The name of the Platform to search for.
     * @return The found Platform or null if not found.
     */
    @Override
    public Platform findByName(String name) {
        return platformDAO.findByName(name);
    }
}

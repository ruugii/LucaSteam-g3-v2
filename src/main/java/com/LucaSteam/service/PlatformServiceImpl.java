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
    @Override
    public void save(Platform p) {
        platformDAO.save(p);
    }

    @Override
    public Platform findByName(String name) {
        return platformDAO.findByName(name);
    }
}

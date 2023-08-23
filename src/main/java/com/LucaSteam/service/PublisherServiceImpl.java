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
    @Override
    public void save(Publisher p) {
        publisherDAO.save(p);
    }

    @Override
    public Publisher findByName(String name) {
        return publisherDAO.findByName(name);
    }
}

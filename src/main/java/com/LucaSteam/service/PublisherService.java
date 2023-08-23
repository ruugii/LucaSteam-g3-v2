package com.LucaSteam.service;

import com.LucaSteam.model.Publisher;

public interface PublisherService {
    public void save(Publisher p);

    public Publisher findByName(String name);

}

package com.LucaSteam.service;

public interface PlatformService {
    public void save(Platform p);

    public Platform findByName(String name);
}

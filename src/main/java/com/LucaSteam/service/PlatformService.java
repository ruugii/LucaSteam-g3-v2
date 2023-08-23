package com.LucaSteam.service;

import com.LucaSteam.model.Platform;

public interface PlatformService {
    public void save(Platform p);

    public Platform findByName(String name);
}

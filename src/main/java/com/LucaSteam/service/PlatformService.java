package com.LucaSteam.service;

import java.util.Optional;

import com.LucaSteam.model.Platform;

public interface PlatformService {
	
	public Optional<Platform> findByName(Platform platform);

}

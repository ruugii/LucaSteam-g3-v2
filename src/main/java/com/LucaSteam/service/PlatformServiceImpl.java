package com.LucaSteam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.model.Platform;
import com.LucaSteam.repository.GameRepository;

@Service
public class PlatformServiceImpl implements PlatformService{
	
	@Autowired
	private GameRepository gameRepo;

	@Override
	public Optional<Platform> findByName(Platform platform) {
		return gameRepo.findByName(platform);
	}
}

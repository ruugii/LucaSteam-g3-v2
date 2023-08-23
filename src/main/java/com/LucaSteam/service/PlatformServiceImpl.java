package com.LucaSteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.repository.PlatformRepository;

@Service
public class PlatformServiceImpl implements PlatformService{
	
	@Autowired
	private PlatformRepository platRepo;

	@Override
	public String findPlatformByName(String platform_name) {
		return platRepo.findPlatformByName(platform_name);
	}
}

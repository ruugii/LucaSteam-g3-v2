package com.LucaSteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.repository.GameRepository;

@Service
public class PublisherServiceImpl implements PublisherService{
	
	@Autowired
	private GameRepository gameRepo;

	@Override
	public String findPublisherByName(String publisher_name) {
		return gameRepo.findPublisherByName(publisher_name);
	}
}

package com.LucaSteam.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LucaSteam.model.Publisher;
import com.LucaSteam.repository.GameRepository;

@Service
public class PublisherServiceImpl implements PublisherService{
	
	@Autowired
	private GameRepository gameRepo;

	@Override
	public Optional<Publisher> findByName(Publisher publisher) {
		return gameRepo.findByName(publisher);
	}

}

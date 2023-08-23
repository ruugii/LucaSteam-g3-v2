package com.LucaSteam.service;

import java.util.Optional;

import com.LucaSteam.model.Publisher;

public interface PublisherService {
	
	public Optional<Publisher> findByName(Publisher publisher);

}

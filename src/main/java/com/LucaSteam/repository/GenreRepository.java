package com.LucaSteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LucaSteam.model.Genre;

public interface GenreRepository extends JpaRepository<Genre,Integer>{
	
}

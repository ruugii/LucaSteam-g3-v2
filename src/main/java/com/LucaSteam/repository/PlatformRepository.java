package com.LucaSteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.LucaSteam.model.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Integer>{

	@Query("FROM Platform WHERE platform_name =?1")
	public String findPlatformByName(String platform_name);
	
}

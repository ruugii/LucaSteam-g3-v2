package com.LucaSteam.repository;

import com.LucaSteam.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformDAO extends JpaRepository<Platform,Long> {
    @Query("FROM Platform WHERE platform_name =?1")
    Platform findByName(String name);
}

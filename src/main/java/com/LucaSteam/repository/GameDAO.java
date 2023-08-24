package com.LucaSteam.repository;

import com.LucaSteam.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDAO extends JpaRepository<Game, Long> {
    Game findByName(String name);
}

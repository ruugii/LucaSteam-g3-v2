package com.LucaSteam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LucaSteam.model.Game;

public interface GameRepository extends JpaRepository<Game,Integer>{
	
	/** FUNCTION USING save() FROM JPAREPOSITORY MEANT TO UPDATE DATA FROM AN OBJECT GAME
	 * 
	 *  @param <Game> 
	 *  
	 */
	public Optional<Game> update(Game game);
}

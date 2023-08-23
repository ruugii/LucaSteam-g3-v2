package com.LucaSteam.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;
import com.LucaSteam.model.Platform;
import com.LucaSteam.model.Publisher;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer>{
	
	/** FUNCTION USING save() FROM JPAREPOSITORY MEANT TO UPDATE DATA FROM AN OBJECT GAME
	 * 
	 *  @param <Game> 
	 *  
	 */
	public Optional<Game> update(Game game);
	
	public Optional<Platform> findByPlatform(Platform platform);
	
	public List<DTOGames> findAllDTOGames();
	
	@Query("FROM Platform WHERE platform_name =?1")
	public String findPlatformByName(String platform_name);
	
	@Query("FROM Genre WHERE genre_name =?1")	
	public String findGenreByName(String genre_name);
	
	@Query("FROM Publisher WHERE publisher_name =?1")
	public String findPublisherByName(String publisher_name);
	
	
}

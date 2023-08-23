package com.LucaSteam.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;
import com.LucaSteam.model.Platform;
import com.LucaSteam.service.GameService;



@RestController
@RequestMapping("/game")
public class GameController {
	
	private static final Logger logger = LoggerFactory.getLogger(GameController.class);

	@Autowired
	private GameService gameServ;
	@Autowired
	private PlatformService platformServ;
	@Autowired
	private GenreService genreServ;
	@Autowired
	private PublisherService publisherServ;

	
	
	@PostMapping("/add")
	public Game save(@RequestBody Game game) {
		
		logger.info("------ save (POST)");
		Game result = this.gameServ.save(game);
		logger.info("------ Dato Salvado " + result);
		
		return result;
	}
	
	@GetMapping
	// @RequestMapping(method = RequestMethod.GET)
	public List<Games> findAll() {
		return gameServ.findAll();
	}
	
	
	
	//return platformServ.findById(id).orElseThrow(StudentNotFoundException::new);
	//falta preparar las excepciones para postman
	
	@GetMapping("/{platform_name}")
	public Optional<Platform> findByNamePlatform(
			//@Parameter(description = "nombre de Platform a localizar", required=true) 
			@PathVariable String platform_name) {			
		logger.info("------ readPlatform (GET) ");
		return platformServ.findByName(platform_name));
	}
	
	@GetMapping("/{genre_name}")
	public Optional<Genre> findByNameGenre(
			//@Parameter(description = "nombre de Platform a localizar", required=true) 
			@PathVariable String genre_name) {			
		logger.info("------ readGenre(GET) ");
		return genreServ.findByName(genre_name));
	}
	
	@GetMapping("/{publisher_name}")
	public Optional<Publisher> findByNamePublisher(
			//@Parameter(description = "nombre de Platform a localizar", required=true) 
			@PathVariable String publisher_name) {			
		logger.info("------ readPublisher(GET) ");
		return publisherServ.findByName(publisher_name));
	}
	
}

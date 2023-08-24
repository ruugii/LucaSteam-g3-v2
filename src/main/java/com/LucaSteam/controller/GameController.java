package com.LucaSteam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;
import com.LucaSteam.model.Platform;
import com.LucaSteam.model.Publisher;
import com.LucaSteam.model.DTO.GameDTO;
import com.LucaSteam.service.GameService;
import com.LucaSteam.service.GenreService;
import com.LucaSteam.service.PlatformService;
import com.LucaSteam.service.PublisherService;
import com.LucaSteam.service.CreateObjects.CreateObjectGame;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.validation.Valid;


@RestController
@Validated
@RequestMapping("/game")
@Tag(name = "game", description = "the Game API")
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

	/**
	 * Given an object gameDTO
	 * Created a Game whit @param gameDTO
	 * Created a result whit (DDBB -> Game) @param called by the name 
	 * @return that game if exist	 * */
	@PostMapping
	public Game save(@Valid @RequestBody GameDTO gameDTO) {
		System.out.println("------ save (POST) " + gameDTO);
		Game game = CreateObjectGame.createGame(gameDTO.getName(), gameDTO.getPlatform(), gameDTO.getYear(), gameDTO.getGenre(), gameDTO.getPublisher(), String.valueOf(gameDTO.getSales()));
		System.out.println("------ save (POST) " + game);
		logger.info("------ save (POST)");
		this.gameServ.save(game);
		Game result = gameServ.findByName(game.getName());
		logger.info("------ Dato Salvado " + result);
		return result;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		gameServ.deleteById(id);
	}
	
	// http://127.0.0.1:3000/v3/api-docs
	// http://127.0.0.1:3000/swagger-ui/index.html#/
	@Operation(summary = "Search Games by ID", description = "Gived an ID, returns and object Game", tags= {"game"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Game located", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Game.class)) }),
			@ApiResponse(responseCode = "400", description = "Not valid (NOT implemented) ", content = @Content),
			@ApiResponse(responseCode = "404", description = "Game not found (NOT implemented)", content = @Content) })
	@GetMapping
	//@RequestMapping(method = RequestMethod.GET)
	public List<Game> findAll() {
		//@Parameter(description = "ID del estudiante a localizar", required=true) 
		return gameServ.findAll();
	}

	//return platformServ.findById(id).orElseThrow(StudentNotFoundException::new);
	//falta preparar las excepciones para postman

	//TODO: IMPLEMENTAR EL METODO DE BUSQUEDA POR NOMBRE DE PLATAFORMA
	@GetMapping("/{platform_name}")
	public Platform findByNamePlatform(
			//@Parameter(description = "nombre de Platform a localizar", required=true) 
			@PathVariable String platform_name) {
		logger.info("------ readPlatform (GET) ");
		return platformServ.findByName(platform_name);
	}

	@GetMapping("/{genre_name}")
	public Genre findByNameGenre(
			//@Parameter(description = "nombre de Platform a localizar", required=true) 
			@PathVariable String genre_name) {
		logger.info("------ readGenre(GET) ");
		return genreServ.findByName(genre_name);
	}

	@GetMapping("/{publisher_name}")
	public Publisher findByNamePublisher(
			//@Parameter(description = "nombre de Platform a localizar", required=true) 
			@PathVariable String publisher_name) {
		logger.info("------ readPublisher(GET) ");
		return publisherServ.findByName(publisher_name);
	}

	   /**
     * Updates an existing game in the database.
     *
     * @param gameDTO The data transfer object containing updated game information.
     * @return The updated game entity.
     */
	@PutMapping
	public Game update(@Valid @RequestBody GameDTO gameDTO) {
		Game g = CreateObjectGame.createGame(gameDTO.getName(), gameDTO.getPlatform(), gameDTO.getYear(), gameDTO.getGenre(), gameDTO.getPublisher(), String.valueOf(gameDTO.getSales()));
		logger.info("------ update (PUT) " + g);
		g.setId(gameDTO.getId());
		return gameServ.update(g);
	}

	@GetMapping("FindById/{id}")
	public Game findById(@PathVariable long id) {
		logger.info("------ read (GET) ");
		return gameServ.findById(id);
	}

}

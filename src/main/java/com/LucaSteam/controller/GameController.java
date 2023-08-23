package com.LucaSteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LucaSteam.model.Game;
import com.LucaSteam.service.GameService;



@RestController
@RequestMapping("/game")
public class GameController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private GameService serv;
	
	
	@PostMapping("/add")
	public Game save(@RequestBody Game game) {
		
		logger.info("------ save (POST)");
		Game result = this.serv.save(game);
		logger.info("------ Dato Salvado " + result);
		
		return result;
	}
}

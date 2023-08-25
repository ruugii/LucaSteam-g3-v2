package com.LucaSteam;


import com.LucaSteam.controller.GameController;

import com.LucaSteam.model.DTO.GameDTO;
import com.LucaSteam.model.Game;
import com.LucaSteam.service.GameServiceImpl;
import com.LucaSteam.utilities.DocumentRead;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ControllerApplicationTests {
	
	@Autowired
	private GameController gc;
	
	@Test
	void FileExists() {
		File file = new File("src/main/java/com/LucaSteam/resources/files/data.csv");
		assertTrue(file.exists());
	}

	@Test
	void numberOfLines() {
		ArrayList<String> lines = DocumentRead.InicialData("src/main/java/com/LucaSteam/resources/files/data.csv");
		int lines_values = lines.size();
		int valuesBBDD = gc.findAll().size();
		assertTrue(lines_values <= valuesBBDD);
	}

	@Test
	void fileIsNotEmpty() {
		GameServiceImpl genreService = new GameServiceImpl();
		ArrayList<String> lines = DocumentRead.InicialData("src/main/java/com/LucaSteam/resources/files/data.csv");
		boolean lines_values = lines.isEmpty();
		assertTrue(!lines_values);
	}

	@Test
	void isGameAdded() {
	    int lines1 = gc.findAll().size();
		GameDTO gdto = new GameDTO();
		gdto.setName("Game5" + lines1);
		gdto.setYear(2023);
		gdto.setSales(5);
		gdto.setGenre("Genre5" + lines1);
		gdto.setPlatform("Platform5"+ lines1);
		gdto.setPublisher("Publisher5"+ lines1);
		gc.save(gdto);
	    int lines2 = gc.findAll().size();
	    assertTrue(lines1 == (lines2 -1));
	}

	@Test
	void isGameDeleted() {
		int lines1 = gc.findAll().size();
		GameDTO gdto = new GameDTO();
		gdto.setName("Game5" + lines1);
		gdto.setYear(2023);
		gdto.setSales(5);
		gdto.setGenre("Genre5" + lines1);
		gdto.setPlatform("Platform5"+ lines1);
		gdto.setPublisher("Publisher5"+ lines1);
		gc.save(gdto);
		System.out.println("TO BE DELETED: " + gc.findById(gc.findAll().get(gc.findAll().size()-1).getId()));
		long toBeDeleted = gc.findAll().get(gc.findAll().size()-1).getId();
		gc.deleteById(toBeDeleted);
		assertTrue(gc.findById(toBeDeleted) == null);
	}
	
	@Test
	void numberOfLinesAfterDelete() {
		int aux = gc.findAll().size();
		GameDTO gdto = new GameDTO();
		gdto.setName("Game5" + aux);
		gdto.setYear(2023);
		gdto.setSales(5);
		gdto.setGenre("Genre5" + aux);
		gdto.setPlatform("Platform5"+ aux);
		gdto.setPublisher("Publisher5"+ aux);
		gc.save(gdto);
		int lines1 = gc.findAll().size();

		long toBeDeleted = gc.findAll().get(gc.findAll().size()-1).getId();
		gc.deleteById(toBeDeleted);
		int lines2 = gc.findAll().size();
		assertTrue((lines1 -1) == lines2);
	}
	
	@Test
	void isSameObject() {
		int aux = gc.findAll().size();
		GameDTO gdto = new GameDTO();
		gdto.setName("Game5" + aux);
		gdto.setYear(2023);
		gdto.setSales(5);
		gdto.setGenre("Genre5" + aux);
		gdto.setPlatform("Platform5"+ aux);
		gdto.setPublisher("Publisher5"+ aux);
		gc.save(gdto);
		assertEquals(gc.findById(aux+1).getClass(), GameDTO.class);
	}
}

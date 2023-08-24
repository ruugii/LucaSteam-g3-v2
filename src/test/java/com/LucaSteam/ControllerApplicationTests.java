package com.LucaSteam;

import com.LucaSteam.model.Game;
import com.LucaSteam.service.GameServiceImpl;
import com.LucaSteam.service.GenreService;
import com.LucaSteam.utilities.DocumentRead;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class ControllerApplicationTests {
	@Test
	void FileExists() {
		File file = new File("src/main/java/com/LucaSteam/resources/files/data.csv");
		assertTrue(file.exists());
	}

	@Test
	void numberOfLines() {
		GameServiceImpl genreService = new GameServiceImpl();
		ArrayList<String> lines = DocumentRead.InicialData("src/main/java/com/LucaSteam/resources/files/data.csv");
		int lines_values = lines.size();
		int valuesBBDD = genreService.findAll().size();
		assertTrue(lines_values == valuesBBDD);
	}

	@Test
	void fileIsNotEmpty() {
		GameServiceImpl genreService = new GameServiceImpl();
		ArrayList<String> lines = DocumentRead.InicialData("src/main/java/com/LucaSteam/resources/files/data.csv");
		boolean lines_values = lines.isEmpty();
		assertTrue(!lines_values);
	}
}

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ControllerApplicationTests {
	
	@Autowired
	private GameController gc;
	
//	@Test
//	void FileExists() {
//		File file = new File("src/main/java/com/LucaSteam/resources/files/data.csv");
//		assertTrue(file.exists());
//	}
//
//	@Test
//	void numberOfLines() {
//		ArrayList<String> lines = DocumentRead.InicialData("src/main/java/com/LucaSteam/resources/files/data.csv");
//		int lines_values = lines.size();
//		int valuesBBDD = gc.findAll().size();
//		assertTrue(lines_values <= valuesBBDD);
//	}
//
//	@Test
//	void fileIsNotEmpty() {
//		GameServiceImpl genreService = new GameServiceImpl();
//		ArrayList<String> lines = DocumentRead.InicialData("src/main/java/com/LucaSteam/resources/files/data.csv");
//		boolean lines_values = lines.isEmpty();
//		assertTrue(!lines_values);
//	}
//
//	@Test
//	void isGameAdded() {
//	    int lines1 = gc.findAll().size();
//		GameDTO gdto = new GameDTO();
//		gdto.setName("Game5" + lines1);
//		gdto.setYear(2023);
//		gdto.setSales(5);
//		gdto.setGenre("Genre5" + lines1);
//		gdto.setPlatform("Platform5"+ lines1);
//		gdto.setPublisher("Publisher5"+ lines1);
//		gc.save(gdto);
//	    int lines2 = gc.findAll().size();
//	    assertTrue(lines1 == (lines2 -1));
//	}
//
//	@Test
//	void isGameDeleted() {
//		int lines1 = gc.findAll().size();
//		GameDTO gdto = new GameDTO();
//		gdto.setName("Game5" + lines1);
//		gdto.setYear(2023);
//		gdto.setSales(5);
//		gdto.setGenre("Genre5" + lines1);
//		gdto.setPlatform("Platform5"+ lines1);
//		gdto.setPublisher("Publisher5"+ lines1);
//		gc.save(gdto);
//		System.out.println("TO BE DELETED: " + gc.findById(gc.findAll().get(gc.findAll().size()-1).getId()));
//		long toBeDeleted = gc.findAll().get(gc.findAll().size()-1).getId();
//		gc.deleteById(toBeDeleted);
//		assertTrue(gc.findById(toBeDeleted) == null);
//	}
	
	//PRUEBA DE UNITARIA: que el objeto UPDATE y la posición por ID de la base de datos sean iguales
	@Test //jc- SEGURAMENTE BORRAR
	void isGameUpdatedIsDifferentThanBeforeOne() {
		
		long idLast = gc.findAll().get(gc.findAll().size()-1).getId(); //nombre para la ultima posicion
		
		
		long idNew = gc.findAll().get(gc.findAll().size()+1).getId(); //nombre para la NUEVA POSICION
		
		
		Game loadLastPosition = gc.findAll().get(gc.findAll().size()); //ultima posicion metida en una variable
		GameDTO convertedLoadLastPosition = new GameDTO();
		convertedLoadLastPosition.setName(loadLastPosition.getName());
		convertedLoadLastPosition.setYear(loadLastPosition.getYear());
		convertedLoadLastPosition.setSales(loadLastPosition.getSales());
		convertedLoadLastPosition.setGenre(loadLastPosition.getGenreId().getName());
		convertedLoadLastPosition.setPlatform(loadLastPosition.getPlatformId().getName());
		convertedLoadLastPosition.setPublisher(loadLastPosition.getPublisherId().getName());
		convertedLoadLastPosition.setId(loadLastPosition.getId()+1); //nueva id a nueva posicion
		
		gc.save(convertedLoadLastPosition);
		//nueva posicion guardada con datos reales.
		
//		 Game comparedGame = gc.findById(idNew);
		
		//juego con el que vamos a updatear 
		GameDTO NewGame = new GameDTO();
		 NewGame.setName("Game5");
		 NewGame.setYear(2023);
		 NewGame.setSales(5);
		 NewGame.setGenre("Genre5");
		 NewGame.setPlatform("Platform5");
		 NewGame.setPublisher("Publisher5");
		 NewGame.setId(idNew);
		
		System.out.println("\n OBJETO ANTES DE SER MODIFICADO = "+convertedLoadLastPosition.toString()+"\n");
		
		
		gc.update(NewGame);
		
		//guardo cambios del update hecho en otra veriable
		Game loadUpdated = gc.findAll().get(gc.findAll().size()); //ultima posicion metida en una variable
		GameDTO loadUpdatedGame = new GameDTO();
		loadUpdatedGame.setName(loadLastPosition.getName());
		loadUpdatedGame.setYear(loadLastPosition.getYear());
		loadUpdatedGame.setSales(loadLastPosition.getSales());
		loadUpdatedGame.setGenre(loadLastPosition.getGenreId().getName());
		loadUpdatedGame.setPlatform(loadLastPosition.getPlatformId().getName());
		loadUpdatedGame.setPublisher(loadLastPosition.getPublisherId().getName());
		loadUpdatedGame.setId(loadLastPosition.getId()+1); //nueva id a nueva posicion
		
		gc.deleteById(idNew);
		
		System.out.println("\n A MODIFICAR= "+NewGame.toString()+"\n");
		System.out.println("\n MODIFICADO = "+NewGame.toString()+"\n");
		
		assertTrue(convertedLoadLastPosition != loadUpdatedGame);
		//assertEquals(gdto, comparedGame);
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

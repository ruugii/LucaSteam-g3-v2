package com.LucaSteam.component;

import com.LucaSteam.service.CreateObjects.CreateObjectGame;
import com.LucaSteam.utilities.DocumentRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.LucaSteam.service.GameServiceImpl;

import java.util.ArrayList;

/**
 * Component that performs data initialization on application startup.
 */
@Component
public class GameComponent implements ApplicationRunner {
    private GameServiceImpl gameServiceImpl;

    @Autowired
    public GameComponent(GameServiceImpl gameServiceImpl) {
        this.gameServiceImpl = gameServiceImpl;
    }

    /**
     * Initializes game data by reading from a CSV file and populating the database when there is no data on it.
     *
     * @param args Command line arguments (not used, it's because it's a component that it's used when you start the program).
     */
    public void run(ApplicationArguments args) {
        ArrayList<String> games = new ArrayList<>();
        games = DocumentRead.InicialData("src/main/java/com/LucaSteam/resources/files/data.csv");
        if (games == null) {
            return;
        } else if (games.size() == 0) {
            return;
        } else {
            if (gameServiceImpl.findAll().size() == 0) {
                for (String line : games) {
                    String[] hasComilllas = line.split("\"");
                    String[] separateComa = line.split(",");
                    try {
                        if (line.contains(",") && line.split(",").length >= 5) {
                            if (!separateComa[1].contains("\"")) {
                                String[] aux = line.split(",");
                                if (aux[3].equalsIgnoreCase("N/A")) {
                                    gameServiceImpl.save(CreateObjectGame.createGame(aux[1], aux[2], 0, aux[4], aux[5], aux[7]));
                                } else {
                                    gameServiceImpl.save(CreateObjectGame.createGame(aux[1], aux[2], Integer.parseInt(aux[3]), aux[4], aux[5], aux[7]));
                                }
                            } else {
                                String[] aux = hasComilllas[2].split(",");
                                if (aux[2].equalsIgnoreCase("N/A")) {
                                    gameServiceImpl.save(CreateObjectGame.createGame(
                                            "\"" + hasComilllas[1] + "\"",
                                            aux[1], 0, aux[3], aux[4], aux[6]
                                    ));
                                } else {
                                    gameServiceImpl.save(CreateObjectGame.createGame(
                                            "\"" + hasComilllas[1] + "\"",
                                            aux[1], Integer.parseInt(aux[2]), aux[3], aux[4], aux[6]
                                    ));
                                }
                            }
                        }
                    } catch (Error e) {
                        System.out.println("Error");
                    }

                }
            }
        }
    }

}
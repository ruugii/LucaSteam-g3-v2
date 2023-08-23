package com.LucaSteam.repository;

import java.util.ArrayList;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Genre;
import com.LucaSteam.model.Platform;
//import com.LucaSteam.service.CreateObjectGame;
import com.LucaSteam.service.GameService;
import com.LucaSteam.utilities.ReadData;



public class GameDAO {
	
	/**
	 * 
	 * 
	 * */
//public static Game createNewGame() {
//		
//		final String pl, ge;
//		
//			Platform[] ArP = {
//					Platform.PS,
//					Platform.GEN,
//					Platform.DS,
//					Platform.WII,
//					Platform.X360,
//					Platform.XB,
//					Platform.PC,
//					Platform.PSV,
//					Platform.SCD,
//					Platform._3DS,
//					Platform._3DO,
//					Platform._2600,
//					Platform.N64,
//					Platform.PS2,
//					Platform.PSP,
//					Platform.PS3,
//					Platform.SAT,
//					Platform.GB,
//					Platform.GG,
//					Platform.GBA,
//					Platform.SNES,
//					Platform.NES,
//					Platform.DC,
//					Platform.PS4,
//					Platform.XONE,
//					Platform.WIIU,
//					Platform.WS,
//					Platform.NG,
//					Platform.PCFX,
//					Platform._TG16,
//					Platform.GC,
//					Platform.DONT_EXIST
//        };
//
//		String menu = "Selecciona la consola: \n";
//		for (int i = 0; i < ArP.length; i++) {
//		    menu += (i + 1) + ".- " + ArP[i].getName()+"\n\t";
//		}
//		int x = ReadData.readInt(menu);
//		pl = ArP[x-1].getName();
//		
//        Genre [] GeP = {
//                Genre.PLATFORM,
//                Genre.SPORTS,
//                Genre.RACING,
//                Genre.SHOOTER,
//                Genre.MISC,
//                Genre.ACTION,
//                Genre.ROLEPLAYING,
//                Genre.PUZZLE,
//                Genre.FIGHTING,
//                Genre.STRATEGY,
//                Genre.ADVENTURE,
//                Genre.SIMULATION
//        };
//        
//		String menu2 = "Selecciona el genero: \n";
//		for (int j = 0; j < GeP.length; j++) {
//		    menu2 += (j + 1) + ".- " + GeP[j].getName()+"\n\t";
//		}
//		
//		int y = ReadData.readInt(menu2);
//		ge = GeP[y-1].getName();
//
//		return CreateObjectGame.createGame(ReadData.readString("Introduce el nombre:"), pl, ReadData.readInt("Introduce el año:"), ge, ReadData.readString("Introduce el publisher:"));
//
//	}

	public static ArrayList<Game> sortGen(Genre gen){
		return GameService.sortGen(gen);
	}
	
	public static ArrayList<Game> sortConsole(Platform plat){
		return GameService.sortConsole(plat);
	}

	public static ArrayList<Game> S20(){
		return GameService.S20();
	}

	public static ArrayList<Game> pair() {
		return GameService.pair();
	}
}

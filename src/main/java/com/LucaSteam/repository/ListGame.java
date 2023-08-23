package com.LucaSteam.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.LucaSteam.model.Game;
import com.LucaSteam.model.Publisher;

public class ListGame <T>{
	
	private ArrayList<T> listGames;

	/** FUNCTION TO ADD AN OBJECT GAME TO THE ARRAYLIST WHICH CONTAINS ALL AVAILABLE GAMES
	 * 
	 * @param <T> 
	 * @param Game Object containing game's information
	 */

	public ListGame() {
		listGames = new ArrayList<>();
	}

	/** FUNCTION TO ADD AN OBJECT GAME TO THE ARRAYLIST WHICH CONTAINS ALL AVAILABLE GAMES
	 * 
	 * @param <T> 
	 * @param Game Object containing game's information
	 */
	public void addGame(T Game) {
		this.listGames.add(Game);
	}
	
	/** FUNCTION TO CHECK WHETHER A GAME IS ALREADY INCLUDED IN THE LIST
	 * 
	 * @param g Game to check against the existing list
	 * @return
	 */
	public boolean alreadyExist(Game g) {
		for (int i = 0;i< this.listGames.size();i++) {

			if(g.getName() == this.listGames.get(i)) return true;

		}
		return false;
	}
	
	public ArrayList<T> getListGames() {
		return listGames;
	}
	public void setListGames(ArrayList<T> listGames) {
		this.listGames = listGames;
	}

	public ArrayList<Game> getGames(){
		ArrayList<Game> aux = new ArrayList<>();
		for (int i = 0; i < listGames.size(); i++) {
			if (listGames.get(i).getClass() == new Game().getClass()){
				aux.add((Game) listGames.get(i));
			}
		}

		return aux;
	}
	
	public ArrayList<String> getPublishers(){
		HashSet<String> a = new HashSet<>();
		for (int i = 0; i < listGames.size(); i++) {
			if (listGames.get(i).getClass() == Publisher.class){
				Publisher pb = (Publisher) listGames.get(i);
				if (!pb.getName().equalsIgnoreCase("n/a") && !pb.getName().equalsIgnoreCase("Unknown")){
					Publisher pub = (Publisher) listGames.get(i);
					a.add(pub.getName());
				}
			}
		}
		ArrayList<String> aux = new ArrayList<>(a);
		Collections.sort(aux);

		return aux;
	}

	public boolean exists(T t){
		for (int i = 0; i < listGames.size(); i++) {
			if (listGames.get(i) == t){
				return true;
			}
		}
		listGames.add(t);
		return false;
	}



	@Override
	public String toString() {
		return "ListGame [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}


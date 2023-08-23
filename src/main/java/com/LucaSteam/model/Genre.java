package com.LucaSteam.model;

public enum Genre {
	
	//ES MUY MUY POSIBLE QUE FALTEN GENEROS
	
		PLATFORM("PLATFORM"), 
		SPORTS("SPORTS"), 
		RACING("RACING"), 
		SHOOTER("SHOOTER"), 
		MISC("MISC"), 
		ACTION("ACTION"), 
		ROLEPLAYING("ROLE-PLAYING"),
		PUZZLE("PUZZLE"),
		FIGHTING("FIGHTING"),
		STRATEGY("STRATEGY"),
		ADVENTURE("ADVENTURE"),
		SIMULATION("SIMULATION"),
		DONT_EXIST("DONT_EXIST");
		
		String string;

		private Genre(String string) {
			this.string = string;
		}

		public String getName() {
			return string;
		}


}

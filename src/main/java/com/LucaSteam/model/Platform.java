package com.LucaSteam.model;

public enum Platform {

	/**
	 * 
	 * ES MUY MUY MUY PROBABLE QUE FALTEN GENEROS SIN LISTAR
	 * 
	 * NO RECONOCE BIEN 3DS, 2600 Y TENGO QUE PONER "_EN ALGUNOS GRUPOS"
	 * 
	 */

	PS("PS"), GEN("GEN"), DS("DS"), WII("WII"), X360("X360"), XB("XB"), PC("PC"), PSV("PSV"), SCD("SCD"), _3DS("3DS"),
	_3DO("3DO"), _2600("2600"), N64("N64"), PS2("PS2"), PSP("PSP"), PS3("PS3"), SAT("SAT"), GB("GB"), GG("GG"),
	GBA("GBA"), SNES("SNES"), NES("NES"), DC("DC"), PS4("PS4"), XONE("XONE"), WIIU("WIIU"), WS("WS"), NG("NG"),
	PCFX("PCFX"), _TG16("TG16"), GC("GC"), DONT_EXIST("DONT_EXIST");

	String string;

	private Platform(String string) {
		this.string = string;
	}

	public String getName() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
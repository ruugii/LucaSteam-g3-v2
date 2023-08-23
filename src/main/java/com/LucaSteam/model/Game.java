package com.LucaSteam.model;

import java.util.concurrent.Flow.Publisher;



public class Game {

	 private static int count = 0;
	    private int id;
	    private String name;
	    private Platform platform;
	    private int year;
	    private Genre gen;
	    private Publisher pub;

	    public Game(){

	    }
	    public Game(String name, Platform platform, int year, Genre gen, Publisher pub) {
	        this.count++;
	        id = this.count;
	        this.name = name;
	        this.platform = platform;
	        this.year = year;
	        this.gen = gen;
	        this.pub = pub;
	    }

	    public String getValue() {

	        return "Game " + "{" +

	                "name='" + name + '\'' +

	                ", platform=" + platform +

	                ", year=" + year +

	                ", gen=" + gen +

	                ", pub=" + pub +

	                '}';

	    }
	    
	    public int getId() {
	        return id;
	    }


	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Platform getPlatform() {
	        return platform;
	    }

	    public void setPlatform(Platform platform) {
	        this.platform = platform;
	    }

	    public int getYear() {
	        return year;
	    }

	    public void setYear(int year) {
	        this.year = year;
	    }

	    public Genre getGen() {
	        return gen;
	    }

	    public void setGen(Genre gen) {
	        this.gen = gen;
	    }

	    public Publisher getPub() {
	        return pub;
	    }

	    public void setPub(Publisher pub) {
	        this.pub = pub;
	    }

	    @Override
	    public String toString() {
	        return "Game " + id + " {\n\t" +
	                "name: " + name + "\n\t" +
	                "platform: " + platform +
	                "\n\tyear:" + year +
	                "\n\tgen:" + gen +
	                "\n\tpub:" + pub +
	                "\n}";
	    }

	    public String getDocumentFormat() {
	        return id + ","+name+","+platform.getName()+","+year+","+gen.getName()+","+pub;
	    }
}

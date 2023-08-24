package com.LucaSteam.model.DTO;


public class GameDTO {

    long id;
    private String name;
    private int year;
    private long sales;
    private String platform;
    private String genre;
    private String publisher;

    public GameDTO() {
        super();
    }

    public GameDTO(String name, int year, long sales, String platform, String genre, String publisher) {
        super();
        this.name = name;
        this.year = year;
        this.sales = sales;
        this.platform = platform;
        this.genre = genre;
        this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getSales() {
        return sales;
    }

    public void setSales(long sales) {
        this.sales = sales;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

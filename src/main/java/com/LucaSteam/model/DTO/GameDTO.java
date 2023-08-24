package com.LucaSteam.model.DTO;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Data Transfer Object (DTO) representing a Game with associated information.
 */
public class GameDTO {

    long id;
    @NotEmpty(message = "El nombre no debe ser vacío")
    private String name;
    @Max(value = 2023)
    @Positive
    private int year;
    @Positive
    private long sales;
    @NotEmpty(message = "El nombre de la plateforma no debe ser vacío")
    private String platform;
    @NotEmpty(message = "El nombre del género no debe ser vacío")
    private String genre;
    @NotEmpty(message = "El nombre del publisher no debe ser vacío")
    private String publisher;

    public GameDTO() {
        super();
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

    @Override
    public String toString() {
        return "GameDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", sales=" + sales +
                ", platform='" + platform + '\'' +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}

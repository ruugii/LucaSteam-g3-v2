package com.LucaSteam.model;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game")
    private long id;
    @Column(name = "game_name")
    private String name;
    @Column(name = "year")
    private int year;
    @Column(name = "sales")
    private long sales;

    @ManyToOne
    @JoinColumn(name = "id_platform")
    private Platform platformId;
    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre genreId;
    @ManyToOne
    @JoinColumn(name = "id_publisher")
    private Publisher publisherId;

    public Game() {
        super();
    }

    public Game(String name, int year, long sales) {
        super();
        this.name = name;
        this.year = year;
        this.sales = sales;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Platform getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Platform platformId) {
        this.platformId = platformId;
    }

    public Genre getGenreId() {
        return genreId;
    }

    public void setGenreId(Genre genreId) {
        this.genreId = genreId;
    }

    public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }
}

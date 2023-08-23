package com.LucaSteam.model;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    private long id;
    private String name;
    private int year;
    private long sales;

    public Game() {
        super();
    }

    public Game(String name, int year, long sales) {
        super();
        this.name = name;
        this.year = year;
        this.sales = sales;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game")

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
}

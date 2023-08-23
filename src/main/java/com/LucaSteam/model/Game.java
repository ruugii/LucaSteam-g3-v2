package com.LucaSteam.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {
    private long id;
    private String name;
    private String description;
    private String image;

}

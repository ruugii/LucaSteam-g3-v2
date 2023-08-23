package com.LucaSteam.model;

import javax.persistence.*;

@Entity
@Table(name = "genre")
public class Genre {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_genre")
    private long id;

   @Column(name = "genre_name")
    private String name;

    public Genre() {
        super();
    }

    public Genre(String name) {
        super();
        this.name = name;
    }

    public Genre(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Genre(Genre genre) {
        super();
        this.id = genre.id;
        this.name = genre.name;
    }

    public long getId() {
        return id;
    }

    public void setId(long idGenre) {
        this.id = idGenre;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameGenre) {
        this.name = nameGenre;
    }
}

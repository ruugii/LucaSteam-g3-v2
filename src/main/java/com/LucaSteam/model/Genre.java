package com.LucaSteam.model;

public class Genre {
    private long id;
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

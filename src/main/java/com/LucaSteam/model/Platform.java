package com.LucaSteam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "platform")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_platform")
    private long id_platform;

    @Column(name = "platform_name")
    private String platform_name;


    public Platform() {
        super();
    }

    public Platform(String platform_name) {
        super();
        this.platform_name = platform_name;
    }

    public long getId() {
        return id_platform;
    }

    public void setId(long id) {
        this.id_platform = id;
    }

    public String getName() {
        return platform_name;
    }

    public void setName(String name) {
        this.platform_name = name;
    }

}

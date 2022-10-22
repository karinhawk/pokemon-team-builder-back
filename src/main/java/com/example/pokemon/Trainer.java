package com.example.pokemon;

import javax.persistence.*;

@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String avatar;

    private String favouritePokemon;

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFavouritePokemon() {
        return favouritePokemon;
    }

    public void setFavouritePokemon(String favouritePokemon) {
        this.favouritePokemon = favouritePokemon;
    }

    public Trainer() {
    }

    public Trainer(long id, String name, String avatar, String favouritePokemon) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.favouritePokemon = favouritePokemon;
    }
}

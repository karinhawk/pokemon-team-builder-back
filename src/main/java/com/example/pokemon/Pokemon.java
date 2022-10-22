package com.example.pokemon;
import javax.persistence.*;
import java.util.ArrayList;


@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String sprite;
    private String hires;
    private String thumbnail;
    private String type;

    private String height;
    private String weight;

    private String description;

    private String species;

    private String trainer;

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

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getHires() {
        return hires;
    }

    public void setHires(String hires) {
        this.hires = hires;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public Pokemon(long id, String name, String sprite, String hires, String thumbnail, String type, String height, String weight, String description, String species, String trainer) {
        this.id = id;
        this.name = name;
        this.sprite = sprite;
        this.hires = hires;
        this.thumbnail = thumbnail;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.description = description;
        this.species = species;
        this.trainer = trainer;
    }

    public Pokemon() {
    }
}

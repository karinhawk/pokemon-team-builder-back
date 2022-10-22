package com.example.pokemon;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException() {
        super("Pokemon has not been found");
    }
}

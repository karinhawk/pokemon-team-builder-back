package com.example.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    @Autowired
    PokemonRepository pokemonRepository;

    // CREATE
    public void addPokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }


    // READ

    public Pokemon getPokemonById(long id) {

        Optional<Pokemon> pokemon = pokemonRepository.findById(id);
        return pokemon.get();
    }

    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public void updatePokemonTrainer(long id, Pokemon updatedPokemon) {
        if(updatedPokemon.getTrainer() == null){
        updatedPokemon.setTrainer("trainer");} else {
            updatedPokemon.setTrainer(null);
        }
        pokemonRepository.save(updatedPokemon);
    }

    public List<String> getTypes() {
        return pokemonRepository.getDistinctTypes();
    }

    public List<Pokemon> getPokemonByType(String type) {
        return pokemonRepository.getAllByType(type);
    }
}

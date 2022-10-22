package com.example.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getAllPokemon());
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getPokemonById(id));
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> updatePokemonTrainer(@PathVariable long id) {
        Pokemon updatedPokemon = pokemonService.getPokemonById(id);
        pokemonService.updatePokemonTrainer(id, updatedPokemon);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedPokemon);
    }
}

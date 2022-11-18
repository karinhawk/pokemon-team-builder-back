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

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(PokemonNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

//    @GetMapping("/pokemon")
//    public ResponseEntity<List<Pokemon>> getAllPokemon() {
//        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getAllPokemon());
//    }

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon(@RequestParam(required = false) String type) {

        if (type != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getPokemonByType(type));
        }

        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getAllPokemon());

    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getPokemonById(id));
    }

    @GetMapping("/pokemon/types")
    public ResponseEntity<List<String>> getPokemonTypes() {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getTypes());
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> updatePokemonTrainer(@PathVariable long id) {
        Pokemon updatedPokemon = pokemonService.getPokemonById(id);
        pokemonService.updatePokemonTrainer(id, updatedPokemon);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedPokemon);
    }

}

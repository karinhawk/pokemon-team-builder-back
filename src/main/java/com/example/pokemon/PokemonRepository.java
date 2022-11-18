package com.example.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    @Query(value="SELECT DISTINCT type FROM pokemon ORDER BY type", nativeQuery = true)
    List<String> getDistinctTypes();


    List<Pokemon> getAllByType(String type);
}

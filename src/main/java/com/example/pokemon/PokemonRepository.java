package com.example.pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    //so many default methods we can use!!
    //if we want additional methods we refer to them as derived methods
    //these are usually more unique to our database


    @Query(value="SELECT DISTINCT id FROM greeting", nativeQuery = true)
    List<Long> getDistinctIds();

}

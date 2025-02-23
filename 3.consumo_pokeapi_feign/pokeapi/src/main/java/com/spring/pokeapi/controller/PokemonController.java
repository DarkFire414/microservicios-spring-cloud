package com.spring.pokeapi.controller;

import com.spring.pokeapi.dto.PokemonDTO;
import com.spring.pokeapi.repository.PokeAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokeapi")
@CrossOrigin(origins = "*")
public class PokemonController {

    @Autowired
    private PokeAPIClient pokeAPIClient;

    @GetMapping("/pokemon/{pokemonId}")
    public PokemonDTO getPokemonInfo(
            @PathVariable("pokemonId") int pokemonId
    ) {
        return pokeAPIClient.getPokemonInfo(pokemonId);
    }

}

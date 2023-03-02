package pokemonPrjct.pokemon.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pokemonPrjct.pokemon.Pokemon;
import pokemonPrjct.pokemon.services.PokemonService;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    // Get all Pokemon
    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return pokemonService.getAllPokemon();
    }

    // Get a specific Pokemon by name
    @GetMapping("/{name}")
    public ResponseEntity<Object> getPokemonByName(@PathVariable String name) {
        Pokemon pokemon = pokemonService.getPokemonByName(name);
        if (pokemon != null) {
            return ResponseEntity.ok(pokemon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add a new Pokemon
    @PostMapping
    public ResponseEntity<Void> addPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.addPokemon(pokemon);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Update an existing Pokemon
    @PutMapping("/{name}")
    public ResponseEntity<Void> updatePokemon(@PathVariable String name, @RequestBody Pokemon pokemon) {
        Pokemon existingPokemon = pokemonService.getPokemonByName(name);
        if (existingPokemon != null) {
            pokemon.setName(name);
            pokemonService.updatePokemon(pokemon);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an existing Pokemon
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deletePokemon(@PathVariable String name) {
        Pokemon pokemon = pokemonService.getPokemonByName(name);
        if (pokemon != null) {
            pokemonService.deletePokemon(pokemon);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Other endpoints for interacting with Pokemon entities could be added here
}

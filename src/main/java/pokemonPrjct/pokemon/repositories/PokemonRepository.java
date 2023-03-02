package pokemonPrjct.pokemon.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pokemonPrjct.pokemon.Pokemon;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    // Find a Pokemon by its name
    Optional<Pokemon> findByName(String name);
}

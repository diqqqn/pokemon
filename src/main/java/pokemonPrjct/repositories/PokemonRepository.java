package pokemonPrjct.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pokemonPrjct.entities.PokemonEntity;

public interface PokemonRepository extends CrudRepository<PokemonEntity, Integer> {
    @Query("SELECT p FROM PokemonEntity p WHERE p.id IN (?1, ?2, ?3)")
    List<PokemonEntity> findPokemonsByIds(Integer id1, Integer id2, Integer id3);

<<<<<<< HEAD
    @Query(value = "SELECT * FROM pokemons WHERE who_is_it = 'PC' ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<PokemonEntity> findRandomPCPokemons();
=======
    @Query(value = "SELECT id FROM pokemons WHERE who_is_it = 'PC' ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<PokemonEntity> findRandomPCPokemonId();
>>>>>>> 8f5cce38c9cb07f40a3b7e6324bd34d414a9c4cc
}

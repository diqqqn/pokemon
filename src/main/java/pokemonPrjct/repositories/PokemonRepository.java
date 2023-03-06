package pokemonPrjct.repositories;

import org.springframework.data.repository.CrudRepository;

import pokemonPrjct.entities.PokemonEntity;

public interface PokemonRepository extends CrudRepository<PokemonEntity, Integer> {

}

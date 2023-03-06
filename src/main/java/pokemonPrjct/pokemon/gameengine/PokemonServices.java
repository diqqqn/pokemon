package pokemonPrjct.pokemon.gameengine;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import pokemonPrjct.pokemon.Pokemon;

/**
 * A DTO for the {@link org.springframework.data.jpa.domain.AbstractPersistable} entity
 */
public class PokemonServices implements Serializable {
    private final int playerId;
    private final List<Pokemon> pokemons;

    public PokemonServices(int playerId, List<Pokemon> pokemons) {
        this.playerId = playerId;
        this.pokemons = pokemons;
    }

    public int getPlayerId() {
        return playerId;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public Pokemon getPokemonIndex(Pokemon pokemon) {
        int index = pokemons.indexOf(pokemon);
        return index >= 0 ? pokemons.get(index) : null;
    }

    public Pokemon[] getAvailablePokemon(int id) {
        return pokemons.stream()
                .filter(pokemon -> pokemon.getOwner() == id && pokemon.getCurrentHealth() > 0)
                .toArray(Pokemon[]::new);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonServices entity = (PokemonServices) o;
        return playerId == entity.playerId && Objects.equals(pokemons, entity.pokemons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, pokemons);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "playerId = " + playerId + ", " +
                "pokemons = " + pokemons +
                ")";
    }
}

//Player: Представлява играч в играта. Той има полета като ID на играча, име,
// списък с покемони, които има, активните покемони и броя на победите, които имат.
// Освен това има методи за превключване на активните покемони, избор на атака
// и получаване на броя на оставащите покемони.
//
//        PokemonGameEngine: Представлява игровия двигател, който обработва логиката
//        за един Pokémon. Има полета като име, ниво, HP, атаки и способност за
//        защита на Pokémon. Освен това има методи за понасяне на щети, проверка
//        дали покемонът е припаднал и избиране на произволна атака.
//
//        PokemonServices: Обект за пренос на данни (DTO), използван за обмен на
//        данни между различни части на двигателя на играта. Има поле за ID и
//        методи за получаване на Pokémon по индекс или за получаване на списък
//        с налични Pokémon.
//
//        Всички тези класове са свързани с двигателя на играта и се използват
//        за реализиране на логиката на играта.

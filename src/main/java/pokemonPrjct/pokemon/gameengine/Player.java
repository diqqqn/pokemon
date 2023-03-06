package pokemonPrjct.pokemon.gameengine;

import java.util.List;
import java.util.Optional;

import pokemonPrjct.pokemon.Attack;
import pokemonPrjct.pokemon.Pokemon;

public class Player {
    private final int id;
    private final String name;
    private final List<Pokemon> pokemons;
    private Pokemon activePokemon;
    private int wins;

    public Player(int id, String name, List<Pokemon> pokemons) {
        this.id = id;
        this.name = name;
        this.pokemons = pokemons;
        this.activePokemon = pokemons.get(0);
        this.wins = 0;
    }

    public void setActivePokemon(Pokemon pokemon) {
        if (pokemons.contains(pokemon)) {
            this.activePokemon = pokemon;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public Pokemon getActivePokemon() {
        return activePokemon;
    }

    public void switchActivePokemon(int index) {
        if (index >= 0 && index < pokemons.size() && index != pokemons.indexOf(activePokemon)) {
            setActivePokemon(pokemons.get(index));
        }
    }

    public Optional<Attack> chooseAttack(Pokemon currentPokemon) {
        // to be implemented
        return Optional.empty();
    }

    public int getNumberOfPokemonRemaining() {
        return (int) pokemons.stream()
                .filter(pokemon -> pokemon.getCurrentHealth() > 0)
                .count();
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getWins() {
        return wins;
    }

    public void switchPokemon(PokemonServices pokemonServices) {
        List<Pokemon> availablePokemon = List.of(pokemonServices.getAvailablePokemon(getId()));
        if (availablePokemon.isEmpty()) {
            // no more available pokemon
            return;
        }
        int randomIndex = (int) (Math.random() * availablePokemon.size());
        setActivePokemon(pokemonServices.getPokemonIndex(availablePokemon.get(randomIndex)));
    }
}


//    Добавена е final ключова дума към полетата, за да се посочи, че те не могат да бъдат променени, след като са инициализирани.
//        Добавен Optional<Attack>като тип на връщане, за chooseAttack()да покаже, че може да не върне стойност (ако играчът избере да не атакува).
//        Заменен за цикъл setActivePokemonId()с по-сбито решение с помощта List.contains()на и List.indexOf().
//        Замени цикъла in getNumberOfPokemonRemaining()с поток и count().
//        Заменен Arrays.asList()с List.of()за създаване на списък с налични покемони в switchPokemon(). Това е по-сбито и избягва ненужното създаване на масив.
//        Променен setActivePokemonId()на, setActivePokemon()за да отразява по-добре какво прави.
//        Преименуван параметър в на switchPokemon(), за pokemonServiceда отразява по-добре какво представлява.
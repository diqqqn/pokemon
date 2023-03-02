package pokemonPrjct.pokemon.gameengine;

import pokemonPrjct.pokemon.Attack;
import pokemonPrjct.pokemon.Pokemon;


public class Player {
    private String name;
    private Pokemon[] pokemons;
    private int activePokemonIndex;
    private int wins;

    public Player(String name, Pokemon[] pokemons) {
        this.name = name;
        this.pokemons = pokemons;
        activePokemonIndex = 0;
        wins = 0;
    }

    public String getName() {
        return name;
    }

    public Pokemon[] getPokemons() {
        return pokemons;
    }

    public int getActivePokemonIndex() {
        return activePokemonIndex;
    }

    public Pokemon getActivePokemon() {
        return pokemons[activePokemonIndex];
    }

    public void switchActivePokemon(int index) {
        if (index >= 0 && index < pokemons.length && index != activePokemonIndex) {
            activePokemonIndex = index;
        }
    }

    public Attack chooseAttack(Pokemon attackingPokemon) {
        // to be implemented
        return null;
    }

    public int getNumberOfPokemonRemaining() {
        int count = 0;
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getCurrentHealth() > 0) {
                count++;
            }
        }
        return count;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getWins() {
        return wins;
    }

    public void switchPokemon(PokemonServices pokemonServices) {
        Pokemon[] availablePokemon = pokemonServices.getAvailablePokemon();
        if (availablePokemon.length == 0) {
            // no more available pokemon
            return;
        }
        int randomIndex = (int) (Math.random() * availablePokemon.length);
        setActivePokemonIndex(pokemonServices.getPokemonIndex(availablePokemon[randomIndex]));
    }

    private void setActivePokemonIndex(int index) {
        if (index >= 0 && index < pokemons.length) {
            activePokemonIndex = index;
        }
    }
}

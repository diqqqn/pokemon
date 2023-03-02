package pokemonPrjct.pokemon.gameengine;

public class Player {
    private String name;
    private Pokemon[] pokemons;
    private int activePokemonIndex;

    public Player(String name, Pokemon[] pokemons) {
        this.name = name;
        this.pokemons = pokemons;
        activePokemonIndex = 0;
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
}

package pokemonPrjct.pokemon.gameengine;


public class ComputerPlayer extends Player {
    public ComputerPlayer(String name, Pokemon[] pokemons) {
        super(name, pokemons);
    }

    public Attack selectRandomAttack() {
        Pokemon activePokemon = getActivePokemon();
        return activePokemon.selectRandomAttack();
    }
}


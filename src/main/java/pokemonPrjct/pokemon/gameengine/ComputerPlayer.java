package pokemonPrjct.pokemon.gameengine;

import java.util.Random;
import pokemonPrjct.pokemon.Pokemon;
import pokemonPrjct.pokemon.Attack;
public class ComputerPlayer extends Player {
    public ComputerPlayer(String name, Pokemon[] pokemons) {
        super(name, pokemons);
    }

    public Attack selectRandomAttack() {
        Pokemon activePokemon = getActivePokemon();
        Attack[] attacks = activePokemon.getAttacks();
        Random random = new Random();
        int index = random.nextInt(attacks.length);
        return attacks[index];
    }

    public void switchPokemon() {
        Pokemon[] availablePokemon = getAvailablePokemon();
        if (availablePokemon.length == 0) {
            // no more available pokemon
            return;
        }
        Random random = new Random();
        int index = random.nextInt(availablePokemon.length);
        setActivePokemon(availablePokemon[index]);
    }

    private void setActivePokemon(Pokemon pokemon) {
    }

    private Pokemon[] getAvailablePokemon() {
    }
}

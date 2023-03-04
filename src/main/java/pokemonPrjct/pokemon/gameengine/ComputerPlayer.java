package pokemonPrjct.pokemon.gameengine;

import java.util.List;
import java.util.Random;

import pokemonPrjct.pokemon.Pokemon;
import pokemonPrjct.pokemon.Attack;

public class ComputerPlayer extends Player {
    public ComputerPlayer(int id, String name, Pokemon[] pokemons) {
        super(id, name, List.of(pokemons));
    }

    public Attack selectRandomAttack() {
        Pokemon activePokemon = getActivePokemon();
        Attack[] attacks = activePokemon.getAttacks();
        Random random = new Random();
        int index = random.nextInt(attacks.length);
        return new Attack(attacks[index].getId(), attacks[index].getName(),
                (Type) attacks[index].getType(), attacks[index].getDamage());
    }

    public void switchPokemon(PokemonServices pokemonServices) {
        Pokemon[] availablePokemon = getAvailablePokemon(pokemonServices);
        if (availablePokemon.length == 0) {
            // no more available pokemon
            return;
        }
        Random random = new Random();
        int index = random.nextInt(availablePokemon.length);
        setActivePokemon(availablePokemon[index]);
    }

    public void setActivePokemon(Pokemon pokemon) {
        super.setActivePokemon(pokemon);
    }

    private Pokemon[] getAvailablePokemon(PokemonServices pokemonServices) {
        return pokemonServices.getAvailablePokemon(getId());
    }
}

// The ComputerPlayer class extends the Player class and overrides the switchPokemon()
// and selectRandomAttack() methods to implement the behavior of a computer player.
//
// The selectRandomAttack() method returns a random attack from the active Pokemon's
// list of attacks, and the switchPokemon() method selects a random
// available Pokemon for the computer player to switch to, using the
// getAvailablePokemon() method from the PokemonServices class.

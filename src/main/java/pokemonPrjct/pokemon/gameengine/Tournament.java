package pokemonPrjct.pokemon.gameengine;

import pokemonPrjct.pokemon.Pokemon;

public class Tournament {
    private Player[] players;
    private int currentPlayerIndex;

    public Tournament(Player[] players) {
        this.players = players;
        currentPlayerIndex = 0;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public void switchCurrentPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }

    public boolean isOver() {
        int numActivePlayers = 0;
        for (Player player : players) {
            Pokemon[] pokemons = player.getPokemons();
            boolean hasActivePokemon = false;
            for (Pokemon pokemon : pokemons) {
                if (!pokemon.isFainted()) {
                    hasActivePokemon = true;
                    break;
                }
            }
            if (hasActivePokemon) {
                numActivePlayers++;
            }
        }
        return numActivePlayers <= 1;
    }

    public Player getWinner() {
        for (Player player : players) {
            Pokemon[] pokemons = player.getPokemons();
            boolean hasActivePokemon = false;
            for (Pokemon pokemon : pokemons) {
                if (!pokemon.isFainted()) {
                    hasActivePokemon = true;
                    break;
                }
            }
            if (hasActivePokemon) {
                return player;
            }
        }
        return null;
    }
}

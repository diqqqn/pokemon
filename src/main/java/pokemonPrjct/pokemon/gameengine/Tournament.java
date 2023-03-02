package pokemonPrjct.pokemon.gameengine;

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
        int numFaintedPlayers = 0;
        for (Player player : players) {
            Pokemon[] pokemons = player.getPokemons();
            boolean allFainted = true;
            for (Pokemon pokemon : pokemons) {
                if (!pokemon.isFainted()) {
                    allFainted = false;
                    break;
                }
            }
            if (allFainted) {
                numFaintedPlayers++;
            }
        }
        return numFaintedPlayers == players.length - 1;
    }
}

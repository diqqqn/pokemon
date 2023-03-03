package pokemonPrjct.pokemon.gameengine;

import pokemonPrjct.pokemon.Attack;
import pokemonPrjct.pokemon.Pokemon;


public class Battle {
    private Player player1;
    private Player player2;
    private PokemonServices pokemonServices;

    public Battle(Player player1, Player player2, PokemonServices pokemonServices) {
        this.player1 = player1;
        this.player2 = player2;
        this.pokemonServices = pokemonServices;
    }

    public void start() {
        while (true) {
            Player currentPlayer = getCurrentPlayer();
            Player otherPlayer = getOtherPlayer(currentPlayer);
            System.out.println("It's " + currentPlayer.getName() + "'s turn.");
            Pokemon currentPokemon = currentPlayer.getActivePokemon();
            Attack attack = currentPlayer.chooseAttack(currentPokemon);

            if (attack == null) {
                System.out.println(currentPlayer.getName() + " forfeits the match.");
                Player winner = otherPlayer;
                winner.setWins(winner.getWins() + 1);
                break;
            }

            System.out.println(currentPlayer.getName() + " uses " + attack.getName() + "!");

            int damage = calculateDamage(currentPokemon, attack, otherPlayer.getActivePokemon());
            otherPlayer.getActivePokemon().takeDamage(damage);

            System.out.println(otherPlayer.getActivePokemon().getName() + " takes " + damage + " damage!");

            if (otherPlayer.getActivePokemon().getCurrentHealth() > 0)   {
                System.out.println(otherPlayer.getName() + "'s " + otherPlayer.getActivePokemon().getName() + " faints!");
                otherPlayer.switchPokemon(pokemonServices);
                if (otherPlayer.getNumberOfPokemonRemaining() == 0) {
                    Player winner = currentPlayer;
                    winner.setWins(winner.getWins() + 1);
                    break;
                } else {
                    System.out.println(otherPlayer.getName() + " chooses " + otherPlayer.getActivePokemon().getName() + " to replace " + otherPlayer.getActivePokemon().getName() + "!");
                }
            }
        }
    }

    private Player getCurrentPlayer() {
        return Math.random() < 0.5 ? player1 : player2;
    }

    private Player getOtherPlayer(Player currentPlayer) {
        return currentPlayer == player1 ? player2 : player1;
    }

    private int calculateDamage(Pokemon attackingPokemon, Attack attack, Pokemon defendingPokemon) {
        int baseDamage = attack.getDamage();
        double effectiveness = TypeChart.getEffectiveness(attack.getType(), defendingPokemon.getType());
        double modifier = Math.random() * (1.0 - 0.85) + 0.85;
        double random = Math.random() * (1.0 - 0.15) + 0.85;
        int level = attackingPokemon.getLevel();
        int attackStat = attack.isSpecial() ? attackingPokemon.getSpecialAttack() : attackingPokemon.getAttack();
        int defenseStat = attack.isSpecial() ? defendingPokemon.getSpecialDefense() : defendingPokemon.getDefense();
        int damage = (int) ((((2 * level / 5.0 + 2) * attackStat * baseDamage / defenseStat) / 50 + 2) * effectiveness * modifier * random);
        return damage;
    }
}

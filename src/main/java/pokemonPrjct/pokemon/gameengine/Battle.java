package pokemonPrjct.pokemon.gameengine;

import java.util.Optional;

import pokemonPrjct.pokemon.Attack;
import pokemonPrjct.pokemon.Pokemon;

public class Battle {
    private final int id;
    private final String name;
    private final String appearance;
    private final String type;
    private final double size;
    private final int hp;
    private final int attack;
    private final int defense;
    private final Player player1;
    private final Player player2;
    private final PokemonServices pokemonServices;

    public Battle(int id, String name, String appearance, String type, double size,
                  int hp, int attack, int defense, Player player1, Player player2,
                  PokemonServices pokemonServices) {
        this.id = id;
        this.name = name;
        this.appearance = appearance;
        this.type = type;
        this.size = size;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
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
            Optional<Attack> attack = currentPlayer.chooseAttack(currentPokemon);

            if (attack.isEmpty()) {
                System.out.println(currentPlayer.getName() + " forfeits the match.");
                Player winner = otherPlayer;
                winner.setWins(winner.getWins() + 1);
                break;
            }

            System.out.println(currentPlayer.getName() + " uses " + attack.get().getName() + "!");

            int damage = calculateDamage(currentPokemon, attack.get(), otherPlayer.getActivePokemon());
            otherPlayer.getActivePokemon().takeDamage(damage);

            System.out.println(otherPlayer.getActivePokemon().getName() + " takes " + damage + " damage!");

            if (otherPlayer.getActivePokemon().getCurrentHealth() <= 0) {
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
        double modifier = calculateModifier();
        double random = calculateRandom();
        int level = attackingPokemon.getLevel();
        int attackStat = attackingPokemon.getAttack();
        int defenseStat = defendingPokemon.getDefense();
        int damage = calculateDamageFormula(baseDamage, effectiveness, modifier, random, level, attackStat, defenseStat);
        return damage;
    }

    private double calculateModifier() {
        return Math.random() * (1.0 - 0.85) + 0.85;
    }

    private double calculateRandom() {
        return Math.random() * (1.0 - 0.15) + 0.85;
    }

    private int calculateDamageFormula(int baseDamage, double effectiveness, double modifier, double random, int level, int attackStat, int defenseStat) {
        double numerator = (2.0 * level / 5.0 + 2.0) * baseDamage * attackStat / defenseStat;
        double fraction = numerator / 50.0 + 2.0;
        double finalDamage = fraction * effectiveness * modifier * random;
        return (int) finalDamage;
    }
}
//    Това е Java клас, наречен „Battle“, който представлява битка между двама играчи в играта Pokemon. Той има променливи като id, име, външен вид, тип, размер, hp, атака и защита, които представляват характеристиките на битката. Освен това има два обекта Player, наречени player1 и player2, които представляват двамата играчи в битката, и обект PokemonServices, наречен pokemonServices, който предоставя услуги, свързани с Pokemon.
//
//        Класът има конструктор, който приема няколко параметъра за инициализиране на променливите на екземпляра. Освен това има метод start(), който се използва за започване на битката. Вътре в метода start() се използва цикъл while, за да продължи битката, докато в един от играчите не остане нито един покемон.
//
//        Методите getCurrentPlayer() и getOtherPlayer() се използват за определяне на кой играч е редът и кой играч е опонентът. Методът calculateDamage() изчислява размера на щетите, нанесени от атаката на Pokemon.
//
//        По време на всеки ход на битката активният покемон на текущия играч избира атака и след това защитаващият се покемон понася щети въз основа на силата на атаката, ефективността и други фактори. Ако здравето на защитаващия се покемон достигне нула или по-ниско, той припада и играчът преминава към друг покемон. Ако играчът няма останали покемони, другият играч печели битката.
//
//        Като цяло, Battle класът предоставя рамка за симулиране на битки с Pokemon между двама играчи.
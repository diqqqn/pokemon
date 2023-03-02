package pokemonPrjct.pokemon.gameengine;

import java.util.Random;
import pokemonPrjct.pokemon.Attack;
import pokemonPrjct.pokemon.DefenseAbility;

public class PokemonGameEngine {
    private String name;
    private int level;
    private int hp;
    private Attack[] attacks;
    private DefenseAbility defense;

    public PokemonGameEngine(String name, int level, int hp, Attack[] attacks, DefenseAbility defense) {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.attacks = attacks;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public DefenseAbility getDefense() {
        return defense;
    }

    public void takeDamage(int damage) {
        int actualDamage = defense.reduceDamage(damage);
        hp -= actualDamage;
        if (hp < 0) {
            hp = 0;
        }
    }

    public boolean isFainted() {
        return hp == 0;
    }

    public Attack selectRandomAttack() {
        Random rand = new Random();
        int index = rand.nextInt(attacks.length);
        return attacks[index];
    }
}

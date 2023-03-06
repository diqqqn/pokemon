package pokemonPrjct.pokemon.gameengine;

import java.util.Random;

import pokemonPrjct.pokemon.Attack;
import pokemonPrjct.pokemon.DefenseAbility;

public class PokemonGameEngine {
    private final String name;
    private final int level;
    private int hp;
    private final Attack[] attacks;
    private final DefenseAbility defense;

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

    public void setHp(int hp) {
        this.hp = hp;
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


//    Използвайте частни полета вместо частни полета за пакети: Добра практика е да запазите
//    полетата на клас частни и да предоставите публични методи за получаване и настройка
//    за достъп и модифициране. Това гарантира, че класът капсулира състоянието си и
//    предоставя ясен API на потребителите на класа. Така че можете да промените видимостта
//    на полетата на частни и да предоставите публични методи за получаване за тях.
//
//        Използвайте инжектиране на конструктор за зависимости: DefenseAbilityКласът е зависимост
//        от PokemonGameEngineкласа. Вместо да създавате екземпляр на DefenseAbilityвътре в
//        конструктора на PokemonGameEngine, можете да го предадете като параметър на конструктора.
//        Това прави ясно, че PokemonGameEngineзависи от DefenseAbilityи позволява по-добро тестване
//        и повторно използване на DefenseAbilityкласа.
//        Имайте предвид, че hpполето вече не е така, finalкакто трябва да се актуализира от
//        takeDamage()метода. Също така, setHp()методът е добавен, за да позволи актуализиране на hpполето.
package pokemonPrjct.pokemon.entities;

public class PokemonEntity {
    private String name;
    private String type;
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private String abilities;

    public PokemonEntity(String name, String type, int hp, int attack, int defense, int specialAttack, int specialDefense, int speed, String abilities) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.abilities = abilities;
    }

    public void printPokemonInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Type: " + this.type);
        System.out.println("HP: " + this.hp);
        System.out.println("Attack: " + this.attack);
        System.out.println("Defense: " + this.defense);
        System.out.println("Special Attack: " + this.specialAttack);
        System.out.println("Special Defense: " + this.specialDefense);
        System.out.println("Speed: " + this.speed);
        System.out.println("Abilities: " + this.abilities);
    }
}

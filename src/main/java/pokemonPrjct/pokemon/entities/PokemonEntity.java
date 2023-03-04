package pokemonPrjct.pokemon.entities;

public class PokemonEntity {
    private int id;
    private String name;
    private String appearance;
    private String type;
    private String size;
    private int hp;
    private int attack;
    private int defense;

    public PokemonEntity(int id, String name, String appearance, String type, String size, int hp, int attack, int defense) {
        this.id = id;
        this.name = name;
        this.appearance = appearance;
        this.type = type;
        this.size = size;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public void printPokemonInfo() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Appearance: " + this.appearance);
        System.out.println("Type: " + this.type);
        System.out.println("Size: " + this.size);
        System.out.println("HP: " + this.hp);
        System.out.println("Attack: " + this.attack);
        System.out.println("Defense: " + this.defense);
    }
}


//    Този код дефинира именуван клас PokemonEntity, който представлява атрибутите и поведението
//    на Pokemon.
//
//        Класът има екземплярни променливи id, name, appearance, type, size, hp, attackи defense,
//        които съхраняват съответните свойства на Pokemon.
//
//        Класът има метод на конструктор, който приема стойности за всички променливи на екземпляра
//        и ги инициализира.
//
//        Класът също има метод с име printPokemonInfo(), който отпечатва информацията за
//        Pokemon, включително неговия ID, име, външен вид, тип, размер, HP, атака и защита.
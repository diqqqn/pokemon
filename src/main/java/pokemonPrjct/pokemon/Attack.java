package pokemonPrjct.pokemon;

import pokemonPrjct.pokemon.gameengine.Type;

public class Attack {
    private int id;
    private String name;
    private Type type;
    private int damage;

    public Attack(int id, String name, Type type, int damage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Object getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return name + " (" + damage + " damage)";
    }
}

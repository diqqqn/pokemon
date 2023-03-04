package pokemonPrjct.pokemon;

public class Pokemon {
    private int id;
    private String name;
    private String appearance;
    private String type;
    private String size;
    private int hp;
    private int attack;
    private int defense;

    public Pokemon(String pokemonName, String appearance, String type, String size, int hp, int attack, int defense) {
    }

    public Pokemon() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appearance='" + appearance + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }

    public boolean isFainted() {
        return getCurrentHealth() == 0;
    }

    public void takeDamage(int damage) {
        // implement the method to reduce pokemon's hp by damage
        hp -= damage;
    }

    public int getCurrentHealth() {
        // return the current hp of the pokemon
        return hp;
    }

    public Attack[] getAttacks() {
        // implement the method to return the attacks array of the pokemon
        return null;
    }

    public int getLevel() {
        return 0;
    }

    public int getOwner() {
        return 0;
    }
}


//    Този код дефинира Pokemonкласа, който представлява Pokémon в играта. Има променливи за
//    екземпляри за съхраняване на ID на Pokémon, име, външен вид, тип, размер, точки за здраве (HP),
//    атака и защита. Той също така има гетери и сетери за тези променливи на екземпляра.
//
//        Методът toString()е заменен, за да върне низово представяне на атрибутите на Pokémon.
//
//        Методът isFainted()връща true, ако текущите точки за здраве на Pokémon са 0, което показва,
//        че е припаднал.
//
//        Методът takeDamage(int damage)намалява здравните точки на Pokémon с даденото количество щети.
//
//        Методът getCurrentHealth()връща текущите здравни точки на Pokémon.
//
//        Методът getAttacks()връща масива от атаки на Pokémon.
//
//        Методът getLevel()връща нивото на Pokémon, но винаги връща 0 в текущата реализация.
package pokemonPrjct.pokemon;

public class DefenseAbility {
    private String name;
    private double multiplier;

    public DefenseAbility(String name, double multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }

    public String getName() {
        return name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public int reduceDamage(int damage) {
        return (int) (damage * multiplier);
    }
}

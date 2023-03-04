package pokemonPrjct.pokemon.gameengine;

import java.util.HashMap;
import java.util.Map;


public class TypeChart {
    private static Map<Type, Map<Type, Double>> chart;

    static {
        chart = new HashMap<>();
        chart.put(Type.NORMAL, new HashMap<>());
        chart.get(Type.NORMAL).put(Type.ROCK, 0.5);
        chart.get(Type.NORMAL).put(Type.GHOST, 0.0);
        chart.put(Type.FIRE, new HashMap<>());
        chart.get(Type.FIRE).put(Type.GRASS, 2.0);
        chart.get(Type.FIRE).put(Type.WATER, 0.5);
        chart.get(Type.FIRE).put(Type.FIRE, 0.5);
        chart.get(Type.FIRE).put(Type.ICE, 2.0);
        chart.get(Type.FIRE).put(Type.BUG, 2.0);
        chart.get(Type.FIRE).put(Type.ROCK, 0.5);
        chart.get(Type.FIRE).put(Type.DRAGON, 0.5);
        chart.put(Type.WATER, new HashMap<>());
        chart.get(Type.WATER).put(Type.FIRE, 2.0);
        chart.get(Type.WATER).put(Type.WATER, 0.5);
        chart.get(Type.WATER).put(Type.GRASS, 0.5);
        chart.get(Type.WATER).put(Type.GROUND, 2.0);
        chart.get(Type.WATER).put(Type.ROCK, 2.0);
        chart.get(Type.WATER).put(Type.DRAGON, 0.5);
        chart.put(Type.GRASS, new HashMap<>());
        chart.get(Type.GRASS).put(Type.FIRE, 0.5);
        chart.get(Type.GRASS).put(Type.WATER, 2.0);
        chart.get(Type.GRASS).put(Type.GRASS, 0.5);
        chart.get(Type.GRASS).put(Type.POISON, 0.5);
        chart.get(Type.GRASS).put(Type.GROUND, 2.0);
        chart.get(Type.GRASS).put(Type.FLYING, 0.5);
        chart.get(Type.GRASS).put(Type.BUG, 0.5);
        chart.get(Type.GRASS).put(Type.ROCK, 2.0);
        chart.get(Type.GRASS).put(Type.DRAGON, 0.5);
        chart.put(Type.ELECTRIC, new HashMap<>());
        chart.get(Type.ELECTRIC).put(Type.WATER, 2.0);
        chart.get(Type.ELECTRIC).put(Type.GRASS, 0.5);
        chart.get(Type.ELECTRIC).put(Type.ELECTRIC, 0.5);
        chart.get(Type.ELECTRIC).put(Type.GROUND, 0.0);
        chart.get(Type.ELECTRIC).put(Type.FLYING, 2.0);
        chart.get(Type.ELECTRIC).put(Type.DRAGON, 0.5);
        chart.put(Type.ICE, new HashMap<>());
        chart.get(Type.ICE).put(Type.GRASS, 2.0);
        chart.get(Type.ICE).put(Type.WATER, 0.5);
        chart.get(Type.ICE).put(Type.FIRE, 0.5);
        chart.get(Type.ICE).put(Type.ICE, 0.5);
        chart.get(Type.ICE).put(Type.GROUND, 2.0);
        chart.get(Type.ICE).put(Type.FLYING, 1.0);
        chart.get(Type.ICE).put(Type.PSYCHIC, 1.0);
        chart.get(Type.ICE).put(Type.BUG, 1.0);
        chart.get(Type.ICE).put(Type.ROCK, 2.0);
        chart.get(Type.ICE).put(Type.GHOST, 1.0);
        chart.get(Type.ICE).put(Type.DRAGON, 2.0);
        chart.get(Type.ICE).put(Type.STEEL, 2.0);

        // Poison type
        chart.put(Type.POISON, new HashMap<Type, Double>());
        chart.get(Type.POISON).put(Type.NORMAL, 1.0);
        chart.get(Type.POISON).put(Type.FIGHTING, 0.5);
        chart.get(Type.POISON).put(Type.FLYING, 1.0);
        chart.get(Type.POISON).put(Type.POISON, 0.5);
        chart.get(Type.POISON).put(Type.GROUND, 2.0);
        chart.get(Type.POISON).put(Type.ROCK, 1.0);
        chart.get(Type.POISON).put(Type.BUG, 0.5);
        chart.get(Type.POISON).put(Type.GHOST, 0.5);
        chart.get(Type.POISON).put(Type.STEEL, 0.0);
        chart.get(Type.POISON).put(Type.FIRE, 1.0);
        chart.get(Type.POISON).put(Type.WATER, 1.0);
        chart.get(Type.POISON).put(Type.GRASS, 2.0);
        chart.get(Type.POISON).put(Type.ELECTRIC, 1.0);
        chart.get(Type.POISON).put(Type.PSYCHIC, 2.0);
        chart.get(Type.POISON).put(Type.ICE, 1.0);
        chart.get(Type.POISON).put(Type.DRAGON, 1.0);
        chart.get(Type.POISON).put(Type.DARK, 1.0);


    }

    public static double getEffectiveness(Object type, String type1) {
        return 0;
    }
}

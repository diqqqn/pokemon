package pokemonPrjct.pokemon.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/pokemon_db";
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    public List<Pokemon> getAllPokemon() {
        List<Pokemon> pokemonList = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM pokemon");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setName(rs.getString("name"));
                pokemon.setType(rs.getString("type"));
                pokemon.setHp(rs.getInt("hp"));
                pokemon.setAttack(rs.getInt("attack"));
                pokemon.setDefense(rs.getInt("defense"));
                pokemon.setSpecialAttack(rs.getInt("special_attack"));
                pokemon.setSpecialDefense(rs.getInt("special_defense"));
                pokemon.setSpeed(rs.getInt("speed"));
                pokemon.setAbilities(rs.getString("abilities"));
                pokemonList.add(pokemon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pokemonList;
    }

    public Pokemon getPokemonByName(String name) {
        Pokemon pokemon = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM pokemon WHERE name = ?");
        ) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pokemon = new Pokemon();
                    pokemon.setName(rs.getString("name"));
                    pokemon.setType(rs.getString("type"));
                    pokemon.setHp(rs.getInt("hp"));
                    pokemon.setAttack(rs.getInt("attack"));
                    pokemon.setDefense(rs.getInt("defense"));
                    pokemon.setSpecialAttack(rs.getInt("special_attack"));
                    pokemon.setSpecialDefense(rs.getInt("special_defense"));
                    pokemon.setSpeed(rs.getInt("speed"));
                    pokemon.setAbilities(rs.getString("abilities"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pokemon;
    }
}

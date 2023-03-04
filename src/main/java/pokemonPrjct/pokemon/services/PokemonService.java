package pokemonPrjct.pokemon.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbutils.DbUtils;

import pokemonPrjct.pokemon.Pokemon;

public class PokemonService {
    private static final Logger LOGGER = Logger.getLogger(PokemonService.class.getName());

    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;

    private static final String GET_ALL_POKEMON_QUERY = "SELECT id, name, appearance, type, size, hp, attack, defense FROM pokemon";
    private static final String GET_POKEMON_BY_NAME_QUERY = "SELECT id, name, appearance, type, size, hp, attack, defense FROM pokemon WHERE name = ?";
    private static final String ADD_POKEMON_QUERY = "INSERT INTO pokemon (name, appearance, type, size, hp, attack, defense) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_POKEMON_QUERY = "UPDATE pokemon SET name=?, appearance=?, type=?, size=?, hp=?, attack=?, defense=? WHERE id=?";
    private static final String DELETE_POKEMON_QUERY = "DELETE FROM pokemon WHERE id = ?";

    public PokemonService(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public List<Pokemon> getAllPokemon() {
        List<Pokemon> pokemonList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(GET_ALL_POKEMON_QUERY);
            rs = ps.executeQuery();

            while (rs.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(rs.getInt("id"));
                pokemon.setName(rs.getString("name"));
                pokemon.setAppearance(rs.getString("appearance"));
                pokemon.setType(rs.getString("type"));
                pokemon.setSize(rs.getString("size"));
                pokemon.setHp(rs.getInt("hp"));
                pokemon.setAttack(rs.getInt("attack"));
                pokemon.setDefense(rs.getInt("defense"));
                pokemonList.add(pokemon);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while getting all pokemon", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occurred while closing database resources", e);
            }
        }

        return pokemonList;
    }

    public Pokemon getPokemonByName(String name) {
        Pokemon pokemon = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(GET_POKEMON_BY_NAME_QUERY);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String pokemonName = rs.getString("name");
                String appearance = rs.getString("appearance");
                String type = rs.getString("type");
                String size = rs.getString("size");
                int hp = rs.getInt("hp");
                int attack = rs.getInt("attack");
                int defense = rs.getInt("defense");

                return new Pokemon(pokemonName, appearance, type, size, hp, attack, defense);

            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while getting pokemon by name: " + name, e);
        } finally {
            DbUtils.closeQuietly(conn, ps, rs);
        }

        return null;
    }

    public void addPokemon(Pokemon pokemon) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(ADD_POKEMON_QUERY);
            ps.setString(1, pokemon.getName());
            ps.setString(2, pokemon.getAppearance());
            ps.setString(3, pokemon.getType());
            ps.setString(4, pokemon.getSize());
            ps.setInt(5, pokemon.getHp());
            ps.setInt(6, pokemon.getAttack());
            ps.setInt(7, pokemon.getDefense());

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                LOGGER.info("Pokemon " + pokemon.getName() + " was added to the database.");
            } else {
                LOGGER.warning("Failed to add Pokemon " + pokemon.getName() + " to the database.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while adding the Pokemon to the database", e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void updatePokemon(Pokemon pokemon) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(UPDATE_POKEMON_QUERY);
            ps.setString(1, pokemon.getName());
            ps.setString(2, pokemon.getAppearance());
            ps.setString(3, pokemon.getType());
            ps.setString(4, pokemon.getSize());
            ps.setInt(5, pokemon.getHp());
            ps.setInt(6, pokemon.getAttack());
            ps.setInt(7, pokemon.getDefense());
            ps.setInt(8, pokemon.getId());

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                LOGGER.info("Pokemon with ID " + pokemon.getId() + " was updated in the database.");
            } else {
                LOGGER.warning("Failed to update Pokemon with ID " + pokemon.getId() + " in the database.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while updating the Pokemon in the database", e);
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    public void deletePokemon(Pokemon pokemon) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(DELETE_POKEMON_QUERY);
            ps.setInt(1, pokemon.getId());

            int rowsDeleted = ps.executeUpdate();

            if (rowsDeleted > 0) {
                LOGGER.info("Pokemon with ID " + pokemon.getId() + " was deleted from the database.");
            } else {
                LOGGER.warning("Failed to delete Pokemon with ID " + pokemon.getId() + " from the database.");
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "An error occurred while deleting the Pokemon from the database", e);
        } finally {
            ResultSet rs = null;
            DbUtils.closeQuietly(conn, ps, rs);
        }
    }
}
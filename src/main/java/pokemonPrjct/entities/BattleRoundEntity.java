package pokemonPrjct.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BattleRoundEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private Integer battle_id;

    private Integer round_number;

    private Integer user1_pokemon_id;

    private Integer pc_pokemon_id;

    private Integer user1_hp;

    private Integer pc_hp;

    public BattleRoundEntity() {}

    public BattleRoundEntity(Integer battle_id, Integer round_number, Integer user1_pokemon_id, Integer pc_pokemon_id,
                             Integer user1_hp, Integer pc_hp) {
        this.battle_id = battle_id;
        this.round_number = round_number;
        this.user1_pokemon_id = user1_pokemon_id;
        this.pc_pokemon_id = pc_pokemon_id;
        this.user1_hp = user1_hp;
        this.pc_hp = pc_hp;
    }

    // getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBattle_id() {
        return battle_id;
    }

    public void setBattle_id(Integer battle_id) {
        this.battle_id = battle_id;
    }

    public Integer getRound_number() {
        return round_number;
    }

    public void setRound_number(Integer round_number) {
        this.round_number = round_number;
    }

    public Integer getUser1_pokemon_id() {
        return user1_pokemon_id;
    }

    public void setUser1_pokemon_id(Integer user1_pokemon_id) {
        this.user1_pokemon_id = user1_pokemon_id;
    }

    public Integer getPc_pokemon_id() {
        return pc_pokemon_id;
    }

    public void setPc_pokemon_id(Integer pc_pokemon_id) {
        this.pc_pokemon_id = pc_pokemon_id;
    }

    public Integer getUser1_hp() {
        return user1_hp;
    }

    public void setUser1_hp(Integer user1_hp) {
        this.user1_hp = user1_hp;
    }

    public Integer getPc_hp() {
        return pc_hp;
    }

    public void setPc_hp(Integer pc_hp) {
        this.pc_hp = pc_hp;
    }
}

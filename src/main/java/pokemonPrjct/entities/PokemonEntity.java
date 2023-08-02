package pokemonPrjct.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;
import pokemonPrjct.classes.PType;
import pokemonPrjct.classes.Size;
import pokemonPrjct.classes.WhoPokemonIs;

@Entity
@Table(name = "Pokemons")
public class PokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Integer attack;
    private Integer protection;
    private Integer life;
    private String appearance;
    public String picPath;

    @Enumerated(EnumType.STRING)
    private Size size = Size.Small;

    @Enumerated(EnumType.STRING)
    private WhoPokemonIs whoIsIt = WhoPokemonIs.Coach;

    @Enumerated(EnumType.STRING)
    private PType pType;

    public PType getpType() {
        return pType;
    }

    public void setpType(PType pType) {
        this.pType = pType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WhoPokemonIs getWhoIsIt() {
        return whoIsIt;
    }

    public void setWhoIsIt(WhoPokemonIs whoIsIt) {
        this.whoIsIt = whoIsIt;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    // Uncomment this method
    // public String getPicPath() {
    //     return picPath;
    // }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getProtection() {
        return protection;
    }

    public void setProtection(Integer protection) {
        this.protection = protection;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }


}

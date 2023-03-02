package pokemonPrjct.pokemon.gameengine;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.springframework.data.jpa.domain.AbstractPersistable} entity
 */



public class DefenseAbility implements Serializable {


    private final PK id;

    public DefenseAbility(PK id) {
        this.id = id;
    }

    public PK getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefenseAbility entity = (DefenseAbility) o;
        return Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ")";
    }
}
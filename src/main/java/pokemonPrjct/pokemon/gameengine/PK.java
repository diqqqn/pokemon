package pokemonPrjct.pokemon.gameengine;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link org.springframework.data.jpa.domain.AbstractPersistable} entity
 */
public class PK implements Serializable {
    private final long id;

    public PK(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PK entity = (PK) o;
        return id == entity.id;
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



//    Интерфейсът Serializable, което означава, че неговите обекти могат да бъдат сериализирани и
//    десериализирани към/от поток, което е полезно за прехвърляне на обекти през мрежа или съхраняването им
//    във файл.
//
//        Методите equals, hashCode, и toString също са внедрени, които обикновено се използват в Java
//        за сравняване на обекти, генериране на хеш кодове и създаване на низови представяния на обекти,
//        съответно. Методите equals и hashCodeса базирани на idполето, което означава, че два PK обекта
//        се считат за равни, ако имат еднаква id стойност. Методът toString връща низово представяне на обекта,
//        което включва името на класа и полето id.
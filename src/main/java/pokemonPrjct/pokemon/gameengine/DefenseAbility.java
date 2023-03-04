package pokemonPrjct.pokemon.gameengine;

import java.io.Serializable;
import java.util.Objects;

public class DefenseAbility implements Serializable {

    private final Long id;

    public DefenseAbility(Long id) {
        this.id = id;
    }

    public Long getId() {
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



//    Този код дефинира прост клас, наречен, DefenseAbility който представлява защитната способност на покемон.
//
//        Класът има едно поле, id което е Long обект, представляващ ID на способността за защита.
//        Класът има конструктор, който взема ID и го задава на id полето, както и метод за получаване
//        на id полето.
//
//        Класът също отменя методите equals(), hashCode(), и toString() наследени от Object класа.
//        Методът equals() проверява дали два DefenseAbilityобекта са равни, като сравнява техните idполета,
//        докато hashCode() методът връща хеш код въз основа на idполето. Методът toString() връща
//        низово представяне на DefenseAbility обекта, което включва името на класа и idполето.
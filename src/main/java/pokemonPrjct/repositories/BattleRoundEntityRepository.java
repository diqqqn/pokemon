package pokemonPrjct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pokemonPrjct.entities.BattleRoundEntity;

@Repository
public interface BattleRoundEntityRepository extends JpaRepository<BattleRoundEntity, Integer> {

}

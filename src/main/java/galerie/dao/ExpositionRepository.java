package galerie.dao;

import galerie.entity.Exposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpositionRepository  extends JpaRepository<Exposition, Integer> {

    @Query("select sum (v.prixVente) from Exposition e inner join e.ventes v where e.id = ?1")
    float CAfor (int id);
}

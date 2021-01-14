package galerie.dao;

import galerie.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository  extends JpaRepository<Personne, Integer> {
}

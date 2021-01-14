package galerie.dao;

import galerie.entity.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtisteRepository  extends JpaRepository<Artiste, Integer> {
}

package galerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import galerie.entity.Galerie;
import org.springframework.stereotype.Repository;

// This will be AUTO IMPLEMENTED by Spring 
@Repository
public interface GalerieRepository extends JpaRepository<Galerie, Integer> {

}

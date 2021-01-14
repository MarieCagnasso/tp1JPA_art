package galerie.dao;

import galerie.entity.Exposition;
import galerie.entity.Galerie;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class ExpositionRepositoryTest {

    @Autowired
    private ExpositionRepository expositionRepository;

    @Autowired
    private GalerieRepository galerieRepository;

    @BeforeEach
    public void setUp() throws Exception {

    }

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Tableau'");
        int combienDansLeJeuDeTest = 2;
        long nombre = expositionRepository.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 2 expositions" );
    }

    @Test
    @Sql("test-data.sql")
    public void expositionsDansUneGAlerie(){
        log.info("on crée des expositions, on en ajoute plusieurs à une galerie");
        LocalDateTime today = LocalDateTime.now();


        Galerie galerie = galerieRepository.getOne(1);
        Galerie galerie2 = new Galerie("galerie2","adr");

        galerieRepository.save(galerie2);

        Exposition exposition = new Exposition(today,"expositionTest",10,galerie);
        Exposition exposition2 = new Exposition(today,"expositionTest",10,galerie2);
        expositionRepository.save(exposition);
        expositionRepository.save(exposition2);

        assertEquals(4, expositionRepository.count(), "On doit trouver 4 expositions" );
        assertEquals(3, galerie.getEvenements().size(), "On doit trouver 3 expositions pour la galerie (id=1)" );

        assertThrows(DataIntegrityViolationException.class, () -> {
            galerie.getEvenements().add(exposition2);
        });


    }

    @Test
    @Sql("test-data.sql")
    public void testCA (){
        float res = 1000001.F;
        Exposition exposition = expositionRepository.getOne(1);

        assertEquals(res,exposition.CA());
    }

    @Test
    @Sql("test-data.sql")
    public void testCAbyId (){
        assertEquals(1000001.F,expositionRepository.CAfor(1));
    }

}

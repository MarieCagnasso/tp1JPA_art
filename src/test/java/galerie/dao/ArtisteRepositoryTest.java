package galerie.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class ArtisteRepositoryTest {

    @Autowired
    private ArtisteRepository artisteRepository;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Artiste'");
        int combienDansLeJeuDeTest = 1;
        long nombre = artisteRepository.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 artiste" );
    }



}

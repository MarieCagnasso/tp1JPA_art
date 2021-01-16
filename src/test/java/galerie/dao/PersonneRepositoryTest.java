package galerie.dao;

import galerie.entity.Personne;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class PersonneRepositoryTest {

    @Autowired
    private PersonneRepository personneRepository;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Tableau'");
        int combienDansLeJeuDeTest = 2;
        long nombre = personneRepository.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 2 personnes" );
    }

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void budgetArtTest() {
        float res = 1000001.F;
        Personne client = personneRepository.getOne(2);
        assertEquals(res,client.budgetArt(2021));
    }


}

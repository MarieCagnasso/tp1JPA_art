package galerie.dao;

import galerie.entity.Artiste;
import galerie.entity.Exposition;
import galerie.entity.Galerie;
import galerie.entity.Tableau;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class TableauRepositoryTest {

    @Autowired
    private TableauRepository tableauRepository;

    @Autowired
    private ExpositionRepository expositionRepository;

    @Autowired
    private ArtisteRepository artisteRepository;

    @Test
    @Sql("test-data.sql") // On peut charger des donnnées spécifiques pour un test
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Tableau'");
        int combienDansLeJeuDeTest = 3;
        long nombre = tableauRepository.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 3 tableaux" );
    }

    @Test
    @Sql("test-data.sql")
    public void tableauxPeintreInconnu(){
        log.info("tableaux sans peintre");

        Tableau tableau1 = new Tableau("support","titre",10,10);
        tableauRepository.save(tableau1);

        System.out.println(tableauRepository.findAll());
        assertEquals(4, tableauRepository.count(), "On doit trouver 4 tableaux" );

    }

    @Test
    @Sql("test-data.sql")
    public void tableauxDansExpos(){
        log.info("ajout des mêmes tableaux dans plusieurs expositions");

        Exposition exposition = expositionRepository.getOne(1);
        Exposition exposition1 = expositionRepository.getOne(11);
        Artiste artiste = artisteRepository.getOne(1);

        Tableau tableau1 = new Tableau("support","titre",10,10);
        Tableau tableau2 = new Tableau("support","titre",10,10);
        tableauRepository.save(tableau1);
        tableauRepository.save(tableau2);

        exposition.getOeuvres().add(tableau1);
        exposition.getOeuvres().add(tableau2);
        exposition1.getOeuvres().add(tableau1);
        exposition1.getOeuvres().add(tableau2);

        List res = new ArrayList();
        res.add(tableau1);
        res.add(tableau2);

        assertEquals(res,exposition.getOeuvres(), "les tableaux sont ajoutés" );
        assertEquals(res,exposition1.getOeuvres(), "les tableaux sont ajouté" );

    }

}

package galerie.dao;

import galerie.entity.Exposition;
import galerie.entity.Personne;
import galerie.entity.Tableau;
import galerie.entity.Transaction;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class TransactionRepositoryTest {
    @Autowired
    private TableauRepository tableauRepository;

    @Autowired
    private ExpositionRepository expositionRepository;

    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    @Sql("test-data.sql")
    public void addTransaction(){
        LocalDateTime today = LocalDateTime.now();

        Exposition exposition = expositionRepository.getOne(1);
        Tableau tableau = tableauRepository.getOne(1);
        Tableau tableau1 = tableauRepository.getOne(11);
        Personne personne = personneRepository.getOne(1);

        Transaction transaction1= new Transaction(today,1000000.f,exposition,personne,tableau1);
        transactionRepository.save(transaction1);

        Optional<Transaction> resultat1 = transactionRepository.findById(3);
        assertTrue(resultat1.isPresent(), "une personne et une expo peuvent avoir plusieurs transactions");
        int res = tableau1.getVendu().getId();
        assertEquals(3,res, "le tableau est vendu");

        Transaction transaction3= new Transaction(today,0.f,exposition,personne,tableau);

        // un tableau concerne qu'une transaction
        assertThrows(DataIntegrityViolationException.class, () -> {
            transactionRepository.save(transaction3);
        });
    }
}

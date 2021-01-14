package galerie;

import galerie.dao.ArtisteRepository;
import galerie.dao.PersonneRepository;
import galerie.entity.Artiste;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log4j2 // Génère le 'logger' pour afficher les messages de trace
public class ConsoleApp implements CommandLineRunner {

    @Autowired
    private ArtisteRepository artisteRepository;
    @Autowired
    private PersonneRepository personneRepository;

    @Override
    public void run(String... args) throws Exception {
       /* tapezEnterPourContinuer();
        log.info("Création d'un artiste");
        // On crée des entités dans les sous-classes de 'Item'
        Artiste artiste = new Artiste("dupont", "Dark Side of the Moon", "Pink Floyd");
        // On les enregistre dans la base
        personneRepository.save(artiste);
        // On les retrouve dans les Personnes
        personneRepository.findAll().forEach(System.out::println);*/

    }
    public static void tapezEnterPourContinuer() throws Exception {
        System.out.println("Tapez \"ENTER\" pour continuer...");
        System.in.read();
    }
}

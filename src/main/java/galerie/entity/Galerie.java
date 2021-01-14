package galerie.entity;
import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Galerie {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @Column(unique=true)
    @NonNull
    private String nom;
    
    @Column(unique=true)
    @NonNull
    private String adresse;
    
    //  Mettre en oeuvre la relation oneToMany vers Exposition // targetEntity = Exposition.class, cascade = CascadeType.ALL
    @OneToMany(mappedBy = "organisateur")
    @ToString.Exclude
    private List<Exposition> evenements;

    public float CAannuel(int annee){
        float res = 0.F;
        for (Exposition e : evenements){

            LocalDateTime debut = e.getDebut();
            int duree = e.getDuree();

            debut.plusDays(duree);

            if (debut.getYear() == annee){
                res += e.CA();
            }
        }
        return res;
    }
}

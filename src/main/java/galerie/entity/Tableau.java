package galerie.entity;
import javax.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Tableau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String titre;

    @NonNull
    private String support;

    @NonNull
    private int largeur;

    @NonNull
    private int hauteur;

    @OneToOne(mappedBy = "oeuvre")
    @ToString.Exclude
    private Transaction vendu;

    @ManyToOne
    private Artiste auteur;

    @ManyToMany (mappedBy = "oeuvres")
    @ToString.Exclude
    private List<Exposition> accrochages;

}

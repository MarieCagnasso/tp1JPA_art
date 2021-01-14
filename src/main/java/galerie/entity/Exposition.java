package galerie.entity;
import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Exposition {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NonNull
    private LocalDateTime debut;

    @Column
    @NonNull
    private String intitule;

    @Column(nullable = false)
    @NonNull
    private int duree;

    @ManyToMany
   @JoinTable(
            name = "exposition_Tableaux",
            joinColumns = @JoinColumn(name = "exposition_id"),
            inverseJoinColumns = @JoinColumn(name = "tableau_id"))
    @ToString.Exclude
    private List<Tableau> oeuvres;

    @OneToMany(mappedBy = "lieuDeVente")
    @ToString.Exclude
    private List<Transaction> ventes;

    @ManyToOne @JoinColumn(name="organisateur_id")
    @NonNull
    private Galerie organisateur;

    public float CA (){
        float res = 0.F;
        for (Transaction t : ventes){
            res = res + t.getPrixVente();
        }
        return res;
    }
}

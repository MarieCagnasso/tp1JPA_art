package galerie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString @Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nom;

    @NonNull
    private String adresse;

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    private List<Transaction> achats;

    public Personne( String nom, String adresse){
        this.nom = nom;
        this.adresse = adresse;
        this.achats = new ArrayList<>();
    }

    public float budgetArt(int annee){
        float res = 0.F;

        for (Transaction t : achats){

            if (t.getVenduLe().getYear() == annee){
                res += t.getPrixVente();
            }
        }
        return res;

    }
}

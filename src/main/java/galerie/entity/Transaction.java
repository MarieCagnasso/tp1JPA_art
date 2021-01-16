package galerie.entity;
import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;


@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private LocalDateTime venduLe;

    @NonNull
    private Float prixVente;

    @ManyToOne
    @NonNull
    private Exposition lieuDeVente;

    @ManyToOne
    @NonNull
    private Personne client;

    @OneToOne (cascade = CascadeType.ALL)
    @NonNull
    @JoinColumn  (name = "oeuvre_id", unique = true)
    private  Tableau oeuvre;
/*
    @PrePersist
    private void prePersistFunction(){

        //log.info("PrePersist method called");

        Optional<Transaction> oeuvreInExpo = lieuDeVente.getOeuvres().getOne(oeuvre.getId());

        if (!oeuvreInExpo.isPresent()){

        }

        //if(StringUtils.isEmpty(type)){
         //   type = "STANDARD_CUSTOMER";
        //}
    }
*/

}

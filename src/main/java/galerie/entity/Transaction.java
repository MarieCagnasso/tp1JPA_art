package galerie.entity;
import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


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


}

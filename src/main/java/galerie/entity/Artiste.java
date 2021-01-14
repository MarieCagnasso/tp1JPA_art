package galerie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor @ToString(callSuper = true) @Entity
public class Artiste extends Personne {

    @Column(unique=true)
    @NonNull
    private String biographie;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<Tableau> oeuvres;

    public Artiste( String nom, String adresse,String biographie){
        super(nom,adresse);
        this.biographie = biographie;
        this.oeuvres = new ArrayList<>();

    }
}

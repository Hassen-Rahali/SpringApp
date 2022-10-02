package elif.tn.firstspring.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long idFacture;
    @Column(name="montantRemise")
    private  float mremise;
    @Column(name="montantFacture")
    private float mfacture;
    @Column(name="dateCreationFacture")
    private Date datecreation;
    @Column(name="dateModificationFacture")
    private Date datemodification;
    @Column(name="archive")
    private  boolean archive;


    @OneToMany( mappedBy="facture")
    private Set<DetailFacture> detailFactures;

    @OneToMany( mappedBy="facture")
    @JsonIgnore
    private Set<Reglement> reglements;

    @ManyToOne
            @JsonIgnore
    fournisseur fournisseur;
}

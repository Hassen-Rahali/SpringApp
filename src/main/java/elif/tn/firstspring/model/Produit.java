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
public class Produit implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduit;
    private String codeProduit;
    private  String libelleProduit;
    private float prix;
    @Temporal(TemporalType.DATE)
    private Date dateDerniereModification;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @ManyToOne
    Stock stock;

    @ManyToOne
    CategorieProduit categorieProduit;


    @OneToMany(mappedBy="produit")
    private Set<DetailFacture> detailFactures;



}

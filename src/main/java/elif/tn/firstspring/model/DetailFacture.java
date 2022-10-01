package elif.tn.firstspring.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;






@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailFacture implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idDetailFacture;
    private Integer qteCommande;
    private float TotalDetail;
    private Integer pourcentageRemise;
    private  float montantRemise;


    @ManyToOne
    Produit produit;

    @ManyToOne
    Facture facture;
}
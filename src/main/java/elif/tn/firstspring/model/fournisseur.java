package elif.tn.firstspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class fournisseur implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFournisseur;
    private String codeFournisseur;
    private  String libelleFournisseur;


    @OneToMany( mappedBy="fournisseur")
    @JsonIgnore
    private Set<Facture> facture;

    @OneToOne
    private DetailFournisseur detailFournisseur;

    @ManyToMany(mappedBy = "fournisseurs")
    private Set<SecteurActivite> secteurActivite;


}

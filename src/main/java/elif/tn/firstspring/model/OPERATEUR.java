package elif.tn.firstspring.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OPERATEUR implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOperateur")
    private  long id;
    @Column(name="nom")
    private  String nom;
    @Column(name="prenom")
    private String prenom;
    @Column(name="password")
    private String mdp;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Facture> facture;

}

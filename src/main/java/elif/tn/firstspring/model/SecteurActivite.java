package elif.tn.firstspring.model;
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
public
class SecteurActivite implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSecteurActivite;
    private String codeSecteurActivite;
    private  String libelleSecteurActivite;
   @ManyToMany (mappedBy = "secteurActivités")
   private Set<fournisseur> fournisseurs;
}
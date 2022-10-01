package elif.tn.firstspring.repository;

import elif.tn.firstspring.model.CategorieProduit;
import elif.tn.firstspring.model.DetailFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailFournisseurRepository extends JpaRepository<DetailFournisseur, Long> {
}

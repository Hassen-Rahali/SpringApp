package elif.tn.firstspring.repository;

import elif.tn.firstspring.model.OPERATEUR;
import elif.tn.firstspring.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}

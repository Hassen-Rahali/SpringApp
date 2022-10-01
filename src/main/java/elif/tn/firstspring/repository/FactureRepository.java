package elif.tn.firstspring.repository;

import elif.tn.firstspring.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}

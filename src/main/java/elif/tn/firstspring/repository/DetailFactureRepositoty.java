package elif.tn.firstspring.repository;

import elif.tn.firstspring.model.CategorieProduit;
import elif.tn.firstspring.model.DetailFacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailFactureRepositoty extends JpaRepository<DetailFacture, Long> {
}

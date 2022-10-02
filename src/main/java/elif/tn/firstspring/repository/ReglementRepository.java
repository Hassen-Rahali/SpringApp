package elif.tn.firstspring.repository;

import elif.tn.firstspring.model.OPERATEUR;
import elif.tn.firstspring.model.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReglementRepository extends JpaRepository<Reglement, Long> {
    List<Reglement>findByFacture_IdFacture(Long idFacture);


}

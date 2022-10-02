package elif.tn.firstspring.repository;

import elif.tn.firstspring.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    List<Facture>findByFournisseur_IdFournisseur(Long idFournisseur);
}


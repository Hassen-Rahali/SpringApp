package elif.tn.firstspring.services;

import elif.tn.firstspring.model.SecteurActivite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISecteurActivite {
    List<SecteurActivite> retrieveAllSecteurActivites();

    SecteurActivite addSecteurActivite (SecteurActivite sa);

    SecteurActivite updateSecteurActivite (SecteurActivite sa);

    SecteurActivite retrieveSecteurActivite (Long id);

    void removeSecteurActivite (Long id);

    public void assignSecteurActiviteToFournisseur(Long IdFournisseur , Long IdActivite);
}

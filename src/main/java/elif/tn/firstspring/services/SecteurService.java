package elif.tn.firstspring.services;

import elif.tn.firstspring.model.SecteurActivite;

import elif.tn.firstspring.model.fournisseur;
import elif.tn.firstspring.repository.SecteurActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurService implements ISecteurActivite{

    @Autowired
    private SecteurActiviteRepository SecteurActiviteRepository;

    @Autowired
    private Ifournisseur fournisseurService;




    @Override
    public List<SecteurActivite> retrieveAllSecteurActivites() {
        return SecteurActiviteRepository.findAll();
    }

    @Override
    public SecteurActivite addSecteurActivite(SecteurActivite sa) {
        return SecteurActiviteRepository.save(sa);
    }

    @Override
    public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
        return SecteurActiviteRepository.save(sa);
    }

    @Override
    public SecteurActivite retrieveSecteurActivite(Long id) {
        return SecteurActiviteRepository.findById(id).orElse(null);
    }

    @Override
    public void removeSecteurActivite(Long id) {
        SecteurActiviteRepository.deleteById(id);

    }

    @Override
    public void assignSecteurActiviteToFournisseur(Long IdFournisseur, Long IdActivite) {

        fournisseur f= fournisseurService.retrieveFournisseur(IdFournisseur);
        SecteurActivite sa =retrieveSecteurActivite(IdActivite);
        sa.getFournisseurs().add(f);
        SecteurActiviteRepository.save(sa);



    }


}

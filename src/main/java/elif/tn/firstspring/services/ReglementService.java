package elif.tn.firstspring.services;


import elif.tn.firstspring.model.Facture;
import elif.tn.firstspring.model.Reglement;
import elif.tn.firstspring.repository.FactureRepository;
import elif.tn.firstspring.repository.ReglementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ReglementService implements IReglement {

    @Autowired
    private ReglementRepository reglementRepository;

    @Autowired
    private FactureRepository factureRepository;


    @Override
    public List<Reglement> retrieveReglementByFacture(Long idFacture) {

        return reglementRepository.findByFacture_IdFacture(idFacture);
    }

    @Override
    public Reglement addReglement(Reglement r, Long idFacture) {
        Facture f = factureRepository.findById(idFacture).orElse(null);
        Set<Reglement> reglementSet = f.getReglements();
        float someReglement = 0 ;
        for (Reglement reglement: reglementSet) {
            someReglement += reglement.getMontantPaye();
        }
        if (r.getMontantPaye()<= f.getMfacture()-someReglement){
            f.getReglements().add(r);
            r.setFacture(f);
            factureRepository.save(f);
            return reglementRepository.save(r);
        }
        System.out.println("douuoi");
        return null;
    }
}




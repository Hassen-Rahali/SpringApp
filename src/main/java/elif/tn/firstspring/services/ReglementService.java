package elif.tn.firstspring.services;


import elif.tn.firstspring.model.Reglement;
import elif.tn.firstspring.repository.ReglementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReglementService implements IReglement {

    @Autowired
    private ReglementRepository reglementRepository;


    @Override
    public List<Reglement> retrieveReglementByFacture(Long idFacture) {

        return reglementRepository.findByFacture_IdFacture(idFacture);
    }




}

package elif.tn.firstspring.services;

import elif.tn.firstspring.model.Facture;
import elif.tn.firstspring.model.OPERATEUR;
import elif.tn.firstspring.repository.OperateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class OperateurService implements IOperateur{




    @Autowired

    private OperateurRepository operateurRepository;
    @Autowired
    private IFacture factureService;


    @Override
    public List<OPERATEUR> retrieveAllOperateurs() {
        return operateurRepository.findAll();
    }

    @Override
    public OPERATEUR addOperateur(OPERATEUR o) {
        return operateurRepository.save(o);
    }

    @Override
    public OPERATEUR updateOperateur(OPERATEUR o) {
        return operateurRepository.save(o);
    }

    @Override
    public OPERATEUR retrieveOperateur(Long id) {
        return operateurRepository.findById(id).orElse(null);
    }

    @Override
    public void removeOperateur(Long id) {
         operateurRepository.deleteById(id);

    }

    @Override
    public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
        OPERATEUR o = operateurRepository.findById(idOperateur).orElse(null);
        Facture f = factureService.retrieveFacture(idFacture);
            o.getFacture().add(f);
            operateurRepository.save(o);


    }
}

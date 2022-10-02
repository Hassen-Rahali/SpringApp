package elif.tn.firstspring.services;

import elif.tn.firstspring.model.DetailFournisseur;
import elif.tn.firstspring.model.fournisseur;
import elif.tn.firstspring.repository.DetailFournisseurRepository;
import elif.tn.firstspring.repository.fournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class fournisseurService implements Ifournisseur {

    @Autowired
    private fournisseurRepository fournisseurRepository;
    @Autowired
    private DetailFournisseurRepository detailFournisseurRepository;


    @Override
    public List<fournisseur> retrieveAllFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public fournisseur addFournisseur(fournisseur f) {
        //detailFournisseurRepository.save(f.getDetailFournisseur());
        return fournisseurRepository.save(f);
    }
    @Override
    public fournisseur updateFournisseur(fournisseur f) {
        return fournisseurRepository.save(f);
    }

    @Override
    public fournisseur retrieveFournisseur(Long id) {
        return fournisseurRepository.findById(id).orElse(null);
    }



}


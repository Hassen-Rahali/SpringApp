package elif.tn.firstspring.services;


import elif.tn.firstspring.model.Facture;
import elif.tn.firstspring.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService implements IFacture {

@Autowired
private FactureRepository FactureRepositorry;


    @Override
    public List<Facture> retrieveAllFactures() {
        return FactureRepositorry.findAll();
    }

    @Override
    public void cancelFacture(Long id) {

        Facture f=FactureRepositorry.findById(id).orElse(null);
        f.setArchive(true);
        FactureRepositorry.save(f);




    }

    @Override
    public Facture retrieveFacture(Long id) {
        return FactureRepositorry.findById(id).orElse(null);
    }
}

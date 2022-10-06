package elif.tn.firstspring.services;


import elif.tn.firstspring.model.DetailFacture;
import elif.tn.firstspring.model.Facture;
import elif.tn.firstspring.model.fournisseur;
import elif.tn.firstspring.repository.DetailFactureRepositoty;
import elif.tn.firstspring.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FactureService implements IFacture {

    @Autowired
    private FactureRepository FactureRepositorry;
    @Autowired
    private fournisseurService fournisseurService;
    private fournisseur fr;

    @Autowired
    DetailFactureRepositoty detailFactureRepositoty;


    @Override
    public List<Facture> retrieveAllFactures() {
        return FactureRepositorry.findAll();
    }

    @Override
    public void cancelFacture(Long id) {

        Facture f = FactureRepositorry.findById(id).orElse(null);
        f.setArchive(true);
        FactureRepositorry.save(f);


    }

    @Override
    public Facture retrieveFacture(Long id) {
        return FactureRepositorry.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
        return FactureRepositorry.findByFournisseur_IdFournisseur(idFournisseur);

    }

    @Override
    public Facture addFacture(Facture f, Long idFournisseur) {
        fournisseur fr = fournisseurService.retrieveFournisseur(idFournisseur);
        f.setFournisseur(fr);
        return FactureRepositorry.save(addDetailFacture(f));
    }

    public Facture addDetailFacture(Facture f) {
        float prixRemisDF , prixFacture = 0,prixFactureRemis = 0;
        Set<DetailFacture> detailFactures = f.getDetailFactures();
        for (DetailFacture detailFacture : detailFactures
        ) {

            prixFacture += detailFacture.getPrixTotalDetail();
            prixRemisDF=( detailFacture.getPrixTotalDetail()*detailFacture.getPourcentageRemise())/100;
            prixFactureRemis += prixRemisDF;
            detailFacture.setMontantRemise(prixRemisDF);
            detailFacture.setFacture(f);
            detailFactureRepositoty.save(detailFacture);
        }
       f.setMremise(prixFactureRemis);
        prixFacture -= prixFactureRemis;
        f.setMfacture(prixFacture);
        return  f;
    }
}
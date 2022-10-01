package elif.tn.firstspring.services;

import elif.tn.firstspring.model.Facture;

import java.util.List;

public interface IFacture {

    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);
}

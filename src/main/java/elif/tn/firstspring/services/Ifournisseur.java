package elif.tn.firstspring.services;

import elif.tn.firstspring.model.fournisseur;

import java.util.List;

public interface Ifournisseur {


    List<fournisseur> retrieveAllFournisseurs();
    fournisseur addFournisseur (fournisseur f);
    fournisseur updateFournisseur (fournisseur f);
    fournisseur retrieveFournisseur (Long id);
}

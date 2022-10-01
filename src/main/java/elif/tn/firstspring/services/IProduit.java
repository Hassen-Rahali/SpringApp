package elif.tn.firstspring.services;

import elif.tn.firstspring.model.Produit;

import java.util.List;

public interface IProduit {

    List<Produit> retrieveAllProduits();

    Produit addProduit (Produit p, Long idCategorieProduit, Long idStock);

    Produit updateProduit (Produit p, Long idCategorieProduit, Long idStock);

    Produit retrieveProduit(Long id);
}

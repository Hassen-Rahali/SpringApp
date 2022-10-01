package elif.tn.firstspring.services;

import elif.tn.firstspring.model.CategorieProduit;
import elif.tn.firstspring.model.Produit;
import elif.tn.firstspring.model.Stock;
import elif.tn.firstspring.repository.CategorieProduitRepository;
import elif.tn.firstspring.repository.ProduitRepository;
import elif.tn.firstspring.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitService implements  IProduit{
    @Autowired
    ProduitRepository produit;
    @Autowired
    ICategorieProduit categorieProduit;
    @Autowired
    IStock stock;
    @Override
    public List<Produit> retrieveAllProduits() {
        return produit.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idCategorieProduit, Long idStock) {
        CategorieProduit cat= categorieProduit.retrieveCategorieProduit(idCategorieProduit);
        Stock s=stock.retrieveStock(idStock);
        p.setStock(s);
        p.setCategorieProduit(cat);

        return produit.save(p);
    }

    @Override
    public Produit updateProduit(Produit p, Long idCategorieProduit, Long idStock) {

        CategorieProduit cat= categorieProduit.retrieveCategorieProduit(idCategorieProduit);
        Stock s=stock.retrieveStock(idStock);
        p.setStock(s);
        p.setCategorieProduit(cat);
        return produit.save(p);
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return produit.findById(id).orElse(null);
    }
}

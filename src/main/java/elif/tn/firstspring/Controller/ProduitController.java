package elif.tn.firstspring.Controller;


import elif.tn.firstspring.model.Produit;
import elif.tn.firstspring.model.Stock;
import elif.tn.firstspring.services.IProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Produit")
public class ProduitController {

    @Autowired
    IProduit produitService;


    @GetMapping("/affichageListeProduit")
    List<Produit> affichagerListeProduit(){
        return produitService.retrieveAllProduits();
    }


    @PostMapping("/ajouterProduit/{idCat}/{idstock}")
    Produit ajouterProduit (@RequestBody Produit produit,@PathVariable("idCat") Long idCat ,@PathVariable ("idstock") Long idstock) {
        return produitService.addProduit(produit,idCat,idstock);
    }

    @GetMapping("/retriveProduit/{id}")
    Produit retrieveProduit (@PathVariable("id") long idProduit){
return produitService.retrieveProduit(idProduit);
    }


    @PutMapping("/modifierProduit/{idCat}/{idstock}")
    Produit ModifierProduit (@RequestBody Produit produit,@PathVariable("idCat") Long idCat ,@PathVariable("idstock")Long idstock){
        return produitService.updateProduit(produit,idCat,idstock);
    }

    @GetMapping("/assignProduitToStock/{idProduit}/{idStock}")
     void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
         produitService.assignProduitToStock(idProduit,idStock);

    }

}

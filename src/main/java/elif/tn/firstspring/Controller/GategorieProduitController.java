package elif.tn.firstspring.Controller;


import elif.tn.firstspring.exception.InvalidEntityEmptyIsNotExist;
import elif.tn.firstspring.exception.InvalidEntityExceptionEmty;
import elif.tn.firstspring.exception.InvalidUpperCaseExeption;
import elif.tn.firstspring.model.CategorieProduit;
import elif.tn.firstspring.services.ICategorieProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CategorieProduit")
  public class GategorieProduitController {
    @Autowired
    ICategorieProduit categorieService;


    @GetMapping("/afficherCategorie")
    List<CategorieProduit>  afficherListeCategorie(){
        return categorieService.retrieveAllCategorieProduits();
    }


@PostMapping("/ajouterCategorie")
    CategorieProduit ajouterCategorie(@RequestBody CategorieProduit CatProduit) throws InvalidUpperCaseExeption, InvalidEntityExceptionEmty {
        return categorieService.addCategorieProduit(CatProduit);

    }
    @PutMapping("/ModifierCategorie")
    CategorieProduit ModifierCategorie (@RequestBody CategorieProduit CateProduit) throws InvalidEntityEmptyIsNotExist, InvalidEntityExceptionEmty {
        return categorieService.updateCategorieProduit(CateProduit);
    }
@DeleteMapping("/supprimerCategorie/{id}")
    void supprimerCategorie(@PathVariable("id") long idCategorie){
        categorieService.removeCategorieProduit(idCategorie);
    }
@GetMapping("/afficherCategorieParId/{id}")
CategorieProduit afficherCategorie(@PathVariable("id") long idCategorie){
        return categorieService.retrieveCategorieProduit(idCategorie);
}




}

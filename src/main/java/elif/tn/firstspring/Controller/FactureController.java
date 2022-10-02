package elif.tn.firstspring.Controller;


import elif.tn.firstspring.model.Facture;
import elif.tn.firstspring.services.IFacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("facture")
public class FactureController {
@Autowired
    IFacture factureService;


@GetMapping("/afficherlisteFacture")
List<Facture> afficherListFacture(){
    return factureService.retrieveAllFactures();
}
@GetMapping("/afficherFactureParId/{id}")
Facture afficherFactureParId(@PathVariable("id") Long idFacture){
  return factureService.retrieveFacture(idFacture);

}

@PutMapping("/modifierFacture/{id}")
void cancelFacture(@PathVariable ("id") Long idFacture){
    factureService.cancelFacture(idFacture);
}


@GetMapping("/affichageFacturesFournisseur/{idFournisseur}")
List<Facture> affichageFacturesFournisseur (@PathVariable ("idFournisseur") Long idFournisseur ){
     return factureService.getFacturesByFournisseur(idFournisseur);


}








    }


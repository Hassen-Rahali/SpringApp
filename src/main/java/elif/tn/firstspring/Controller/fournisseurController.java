package elif.tn.firstspring.Controller;


import elif.tn.firstspring.model.fournisseur;
import elif.tn.firstspring.services.Ifournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fournisseur")
public class fournisseurController {
@Autowired

Ifournisseur fournisseurService;

    @GetMapping("/afficherlisteFournisseur")
    List<fournisseur> afficherListFournisseur() {
        return fournisseurService.retrieveAllFournisseurs();
    }

    @GetMapping("/afficherFournisseurParId/{id}")
    fournisseur afficherFournisseurParId(@PathVariable("id") Long idFournisseur){
        return fournisseurService.retrieveFournisseur(idFournisseur);

    }

    @PostMapping("/ajouterFournisseur")
    fournisseur ajouterFournisseur (@RequestBody fournisseur fournisseur) {
        return fournisseurService.addFournisseur(fournisseur);
    }

    @PutMapping("/modifierFournisseur/{id}")
    fournisseur modifierFournisseur (@RequestBody fournisseur idFournisseur){
        return fournisseurService.updateFournisseur(idFournisseur);
    }

}

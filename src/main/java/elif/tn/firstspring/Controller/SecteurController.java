package elif.tn.firstspring.Controller;


import elif.tn.firstspring.model.SecteurActivite;
import elif.tn.firstspring.services.ISecteurActivite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Secteur")
public class SecteurController {

    @Autowired
    ISecteurActivite secteurService;

    @GetMapping("/afficherlisteSecteur")
    List<SecteurActivite> afficherListeSecteur(){
        return secteurService.retrieveAllSecteurActivites();
    }

    @GetMapping("/afficherSecteurParId/{id}")
    SecteurActivite afficheSecteurParId(@PathVariable("id") Long idSecteurActivite){
        return secteurService.retrieveSecteurActivite(idSecteurActivite);
    }

    @PostMapping("/ajouterSecteur")
    SecteurActivite ajouterOperateur (@RequestBody SecteurActivite secteur){
        return secteurService.addSecteurActivite(secteur);

    }
    @PutMapping("/modifierSecteur/{id}")
    SecteurActivite modifierOperateur (@RequestBody SecteurActivite idSecteurActivite){
        return secteurService.updateSecteurActivite(idSecteurActivite);
    }

    @DeleteMapping("/supprimerSecteur/{id}")
    void SecteurActivite (@PathVariable("id") Long idSecteurActivite ) {
        secteurService.removeSecteurActivite(idSecteurActivite);

    }


    @PostMapping("/assignSecteurToFournisseur/{idFourniseur}/{idSecteur}")
void assignSecteurActiviteToFournisseur(@PathVariable("idFourniseur") Long idFournisseur,@PathVariable("idSecteur") Long idSecteur){
        secteurService.assignSecteurActiviteToFournisseur(idFournisseur,idSecteur);
    }





}

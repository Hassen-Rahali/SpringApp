package elif.tn.firstspring.Controller;


import elif.tn.firstspring.model.Reglement;
import elif.tn.firstspring.services.IReglement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reglement")
public class ReglementController {

    @Autowired
    IReglement reglementService;


    @GetMapping("affichageReglementByFacture/{idFacture}")
    List<Reglement> affichageReglementByFacture(@PathVariable("idFacture") Long idFacture) {
        return reglementService.retrieveReglementByFacture(idFacture);

    }

@PostMapping("addReglement/{idFacture}")
    Reglement addReglement (@RequestBody Reglement reglement,@PathVariable ("idFacture") Long idFacture){
        return  reglementService.addReglement(reglement,idFacture);

}



}
package elif.tn.firstspring.Controller;


import elif.tn.firstspring.model.Reglement;
import elif.tn.firstspring.services.IReglement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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




}
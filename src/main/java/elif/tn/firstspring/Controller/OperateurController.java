package elif.tn.firstspring.Controller;


import elif.tn.firstspring.model.OPERATEUR;
import elif.tn.firstspring.services.IOperateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Operateur")
public class OperateurController {

  @Autowired
    IOperateur operateurService;

  @GetMapping("/afficherlisteOperateur")
  List<OPERATEUR> afficherListeOpereteur(){
      return operateurService.retrieveAllOperateurs();
  }

@GetMapping("/afficherOperateurParId/{id}")
  OPERATEUR afficheOperateurParId(@PathVariable("id") Long idOperateur){
      return operateurService.retrieveOperateur(idOperateur);

  }
@PostMapping("/ajouterOperateur")
  OPERATEUR ajouterOperateur (@RequestBody OPERATEUR operateur){
      return operateurService.addOperateur(operateur);

}
@PutMapping("/modifierOperateur/{id}")
OPERATEUR modifierOperateur (@RequestBody OPERATEUR operateur){
      return operateurService.updateOperateur(operateur);
}

@DeleteMapping("/supprimerOperateur/{id}")
void supprimerOperateur (@PathVariable("id") Long idOperateur ) {
      operateurService.removeOperateur(idOperateur);

}
@GetMapping("/assignOperateurToFacture/{idOperateur}/{idFacture}")
void assignOperateurToFacture(@PathVariable("idOperateur")Long idOperateur,@PathVariable("idFacture")Long idFacture){
      operateurService.assignOperateurToFacture(idOperateur,idFacture);
}

}

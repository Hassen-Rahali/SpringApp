package elif.tn.firstspring.services;


import elif.tn.firstspring.exception.InvalidEntityEmptyIsNotExist;
import elif.tn.firstspring.exception.InvalidEntityExceptionEmty;
import elif.tn.firstspring.exception.InvalidUpperCaseExeption;
import elif.tn.firstspring.model.CategorieProduit;
import elif.tn.firstspring.repository.CategorieProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CategorieProduitService implements ICategorieProduit {


@Autowired
private CategorieProduitRepository  categorieRepository;

    @Override
    public List<CategorieProduit> retrieveAllCategorieProduits() {
        return categorieRepository.findAll();

    }

    @Override
    public CategorieProduit addCategorieProduit(CategorieProduit cp) throws InvalidEntityExceptionEmty, InvalidUpperCaseExeption {
        if(cp==null){
            throw new InvalidEntityExceptionEmty("variable is emty");
        }
        if(!cp.getCodeProduit().equals(cp.getCodeProduit().toUpperCase())){
            throw new InvalidUpperCaseExeption("codeProduit should be UpperCase");
        }

        return categorieRepository.save(cp);
    }

    @Override
    public CategorieProduit updateCategorieProduit(CategorieProduit cp) throws InvalidEntityExceptionEmty, InvalidEntityEmptyIsNotExist {
    if(cp==null){
        throw new InvalidEntityExceptionEmty("le donner est vide");
    }
    if(retrieveCategorieProduit(cp.getIdCategorieProduit())==null){
   throw new InvalidEntityEmptyIsNotExist("cette entie nexiste pas") ;
    }
        return categorieRepository.save(cp);
    }

    @Override
    public CategorieProduit retrieveCategorieProduit(Long id) {

        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public void removeCategorieProduit(Long id) {
        categorieRepository.deleteById(id);
    }
}

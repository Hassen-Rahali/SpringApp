package elif.tn.firstspring.services;

import elif.tn.firstspring.exception.InvalidEntityEmptyIsNotExist;
import elif.tn.firstspring.exception.InvalidEntityExceptionEmty;
import elif.tn.firstspring.exception.InvalidUpperCaseExeption;
import elif.tn.firstspring.model.CategorieProduit;

import java.util.List;

public interface ICategorieProduit {
    List<CategorieProduit> retrieveAllCategorieProduits();

    CategorieProduit addCategorieProduit(CategorieProduit cp) throws InvalidEntityExceptionEmty, InvalidUpperCaseExeption;

    CategorieProduit updateCategorieProduit(CategorieProduit cp) throws InvalidEntityExceptionEmty, InvalidEntityEmptyIsNotExist;

    CategorieProduit retrieveCategorieProduit(Long id);

    void removeCategorieProduit(Long id);
}

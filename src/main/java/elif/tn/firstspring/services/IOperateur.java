package elif.tn.firstspring.services;

import elif.tn.firstspring.model.OPERATEUR;

import java.util.List;

public interface IOperateur {

    List<OPERATEUR> retrieveAllOperateurs();

    OPERATEUR addOperateur (OPERATEUR o);

    OPERATEUR updateOperateur (OPERATEUR o);

    OPERATEUR retrieveOperateur (Long id);

    void removeOperateur (Long id);

}

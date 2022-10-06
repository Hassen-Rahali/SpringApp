package elif.tn.firstspring.services;

import elif.tn.firstspring.model.Reglement;

import java.util.List;

public interface IReglement {
    public List<Reglement> retrieveReglementByFacture(Long idFacture);

  public Reglement addReglement (Reglement r , Long idFacture);

}

package elif.tn.firstspring.services;

import elif.tn.firstspring.repository.DetailFactureRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailFactureService implements IDetailFacture{

   @Autowired
   private DetailFactureRepositoty DetailFactureRepository;



}

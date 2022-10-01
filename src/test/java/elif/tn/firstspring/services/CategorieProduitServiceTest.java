package elif.tn.firstspring.services;

import elif.tn.firstspring.exception.InvalidEntityEmptyIsNotExist;
import elif.tn.firstspring.exception.InvalidEntityExceptionEmty;
import elif.tn.firstspring.exception.InvalidUpperCaseExeption;
import elif.tn.firstspring.model.CategorieProduit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategorieProduitServiceTest {

    @Autowired
    private ICategorieProduit Categorie;
@Test
public void shouldThrowInvalidEntityExceptionEmty ()  {

    CategorieProduit VesrionCategorie = null;
    InvalidEntityExceptionEmty InvalidExeption = assertThrows(InvalidEntityExceptionEmty.class,()->Categorie.addCategorieProduit(VesrionCategorie));
    assertEquals("variable is emty",InvalidExeption.getMessage());

}
@Test
    public void shouldThrowInvalidUpperCaseException(){
    CategorieProduit exceptedCategorie = CategorieProduit.builder().codeProduit("abc").libelleCategorieProduit("azerty").build();
    InvalidUpperCaseExeption InvalidExeption = assertThrows(InvalidUpperCaseExeption.class,()->Categorie.addCategorieProduit(exceptedCategorie));
    assertEquals("codeProduit should be UpperCase",InvalidExeption.getMessage());

}
@Test
    public void shouldSaveGategorieSuccess() throws InvalidUpperCaseExeption, InvalidEntityExceptionEmty {
    CategorieProduit exceptedCategorie = CategorieProduit.builder().codeProduit("HASSEN").libelleCategorieProduit("rahali").build();
    CategorieProduit savedCategorie = Categorie.addCategorieProduit(exceptedCategorie);
    assertNotNull(savedCategorie);
    assertNotNull(savedCategorie.getIdCategorieProduit());
    assertEquals(savedCategorie.getCodeProduit(),exceptedCategorie.getCodeProduit());
    assertEquals(savedCategorie.getLibelleCategorieProduit(),exceptedCategorie.getLibelleCategorieProduit());

}
@Test
    public void shouldRetrieveSameTypeCategorieSuccess(){
    CategorieProduit retriveGategorie = Categorie.retrieveCategorieProduit(1L);
    assertEquals(retriveGategorie.getClass(),CategorieProduit.class);
}
@Test
    public void shouldRetrieveSameTypeCategorieNull(){
    CategorieProduit retrieveGategorie = Categorie.retrieveCategorieProduit(4L);
    assertNull(retrieveGategorie);
}
@Test
public void ShouldRetreiveAllGategorieWithSuccess(){
    List<CategorieProduit> ListOfGategorie = Categorie.retrieveAllCategorieProduits();
    assertEquals(ListOfGategorie.getClass(), ArrayList.class);
}
@Test
public void ShouldRetrevieAllGategorieNotEmty(){
    List<CategorieProduit> ListOfGategorie = Categorie.retrieveAllCategorieProduits();
    assertTrue(ListOfGategorie.size() >0);
}
@Test
    public void InvalidEntityForUpdateIsEmpty(){
    CategorieProduit ExeptedCategorie = null;
    InvalidEntityExceptionEmty InvalidException = assertThrows(InvalidEntityExceptionEmty.class,()->Categorie.updateCategorieProduit(ExeptedCategorie));
    assertEquals("le donner est vide",InvalidException.getMessage());
}
@Test
    public void shouldThrowInvalidEntityEmptyIsNotExist(){
    CategorieProduit exceptedCategorie = CategorieProduit.builder().idCategorieProduit(5).libelleCategorieProduit("MAHMOUD").codeProduit("okokokoko").build();
    InvalidEntityEmptyIsNotExist InvalidException = assertThrows(InvalidEntityEmptyIsNotExist.class,()->Categorie.updateCategorieProduit(exceptedCategorie));
    assertEquals(InvalidException.getClass(),InvalidEntityEmptyIsNotExist.class);
    assertEquals("cette entie nexiste pas",InvalidException.getMessage());
}
}
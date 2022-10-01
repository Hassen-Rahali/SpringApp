package elif.tn.firstspring.Controller;


import elif.tn.firstspring.model.Stock;
import elif.tn.firstspring.services.IStock;
import elif.tn.firstspring.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Stock")
public class StockController {
    @Autowired

    IStock  stockService;


@GetMapping("/afficherStock")
List<Stock> afficherStock (){
        return stockService.retrieveAllStocks();
    }

    @GetMapping("/afficherStockParId/{id}")
Stock afficherStockParId (@PathVariable("id") Long idStock) {
   return stockService.retrieveStock(idStock);

    }

    @PostMapping("/ajouterStock")
    Stock ajouterStock (@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @PutMapping("/modifierStock")
    Stock modifierStock (@RequestBody Stock stock){
    return stockService.updateStock(stock);
    }

@DeleteMapping("/supprimerStock/{id}")
    void supprimerStock (@PathVariable ("id") long idStock ) {
         stockService.removeStock(idStock);
    }


}

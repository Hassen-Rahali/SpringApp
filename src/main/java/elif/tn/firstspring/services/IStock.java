package elif.tn.firstspring.services;

import elif.tn.firstspring.model.Stock;

import java.util.List;

public interface IStock {
    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock s);

    Stock retrieveStock(Long id);

    void removeStock(Long id);
}

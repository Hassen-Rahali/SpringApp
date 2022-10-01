package elif.tn.firstspring.repository;

import elif.tn.firstspring.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}

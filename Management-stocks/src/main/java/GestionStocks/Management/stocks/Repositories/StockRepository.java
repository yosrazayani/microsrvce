package GestionStocks.Management.stocks.Repositories;

import GestionStocks.Management.stocks.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}

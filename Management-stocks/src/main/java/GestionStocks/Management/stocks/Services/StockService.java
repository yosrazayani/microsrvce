package GestionStocks.Management.stocks.Services;

import GestionStocks.Management.stocks.Repositories.StockRepository;
import GestionStocks.Management.stocks.ResourceNotFoundException;
import GestionStocks.Management.stocks.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock updateStock(Long id, Stock stockDetails) {
        Optional<Stock> stockOptional = stockRepository.findById(id);
        //patchMapping
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            stock.setName(stockDetails.getName());
            stock.setQuantity(stockDetails.getQuantity());
            stock.setPrice(stockDetails.getPrice());
            return stockRepository.save(stock);
        } else {
            throw new ResourceNotFoundException("Stock not found with id " + id);
        }
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}

package by.pochepko.repository;

import by.pochepko.model.Chocolate;
import by.pochepko.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

    Stock findStockByChocolate(Chocolate chocolate);
}

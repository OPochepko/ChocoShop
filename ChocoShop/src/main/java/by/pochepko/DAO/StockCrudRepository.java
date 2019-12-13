package by.pochepko.DAO;

import by.pochepko.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockCrudRepository extends CrudRepository<Stock, Integer> {
}

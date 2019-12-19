package by.pochepko.services;

import by.pochepko.model.Chocolate;
import by.pochepko.model.Promocode;
import by.pochepko.model.Stock;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DBService {
    @Transactional
    Iterable<Promocode> readPromocodes();

    @Transactional
    Iterable<Stock> loadStock();

    @Transactional
    Iterable<Chocolate> readChocolates();

    @Transactional
    Promocode getPromocodeByCode(String code);

    @Transactional
    int getStockQuantityByChocolate(Chocolate chocolate);

    @Transactional
    Chocolate saveChocolate(Chocolate chocolate);

    @Transactional
    Optional<Chocolate> findChocolateById(int id);

}

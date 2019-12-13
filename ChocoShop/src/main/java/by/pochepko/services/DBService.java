package by.pochepko.services;

import by.pochepko.model.Chocolate;
import by.pochepko.model.PromoCode;
import by.pochepko.model.Stock;
import org.springframework.transaction.annotation.Transactional;

public interface DBService {
    @Transactional
    Iterable<PromoCode> readPromocodes();

    @Transactional
    Iterable<Stock> loadStock();

    @Transactional
    Iterable<Chocolate> readChocolates();

}

package by.pochepko.services;

import by.pochepko.DAO.ChocolateCrudRepository;
import by.pochepko.DAO.PromocodeCrudRepository;
import by.pochepko.DAO.StockCrudRepository;
import by.pochepko.model.Chocolate;
import by.pochepko.model.PromoCode;
import by.pochepko.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpringDataDBService implements DBService {

    @Autowired
    private PromocodeCrudRepository promocodeCrudRepository;
    @Autowired
    private ChocolateCrudRepository chocolateCrudRepository;
    @Autowired
    private StockCrudRepository stockCrudRepository;


    @Transactional
    public Iterable<PromoCode> readPromocodes() {
        return promocodeCrudRepository.findAll();
    }

    @Override
    public Iterable<Stock> loadStock() {
        return stockCrudRepository.findAll();
    }

    @Transactional
    public Iterable<Chocolate> readChocolates() {
        return chocolateCrudRepository.findAll();
    }


}

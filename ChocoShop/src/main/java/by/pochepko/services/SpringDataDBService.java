package by.pochepko.services;

import by.pochepko.DAO.ChocolateCrudRepository;
import by.pochepko.DAO.PromocodeCrudRepository;
import by.pochepko.DAO.StockCrudRepository;
import by.pochepko.model.Chocolate;
import by.pochepko.model.Promocode;
import by.pochepko.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SpringDataDBService implements DBService {

    @Autowired
    private PromocodeCrudRepository promocodeCrudRepository;
    @Autowired
    private ChocolateCrudRepository chocolateCrudRepository;
    @Autowired
    private StockCrudRepository stockCrudRepository;


    @Transactional
    public Iterable<Promocode> readPromocodes() {
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

    @Override
    public Promocode getPromocodeByCode(String code) {
        return promocodeCrudRepository.findByCode(code);
    }

    @Override
    public int getStockQuantityByChocolate(Chocolate chocolate) {
        return stockCrudRepository.findStockByChocolate(chocolate).getQuantity();
    }

    @Override
    public Chocolate saveChocolate(Chocolate chocolate) {
        Chocolate save = chocolateCrudRepository.save(chocolate);
        System.out.println(save);
        return save;
    }

    @Override
    public Optional<Chocolate> findChocolateById(int id) {
        return chocolateCrudRepository.findById(id);
    }


}

package by.pochepko.services;

import by.pochepko.dao.ChocolateRepository;
import by.pochepko.dao.PromocodeRepository;
import by.pochepko.dao.StockRepository;
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
    private PromocodeRepository promocodeRepository;
    @Autowired
    private ChocolateRepository chocolateRepository;
    @Autowired
    private StockRepository stockRepository;


    @Transactional
    public Iterable<Promocode> readPromocodes() {
        return promocodeRepository.findAll();
    }

    @Override
    public Iterable<Stock> loadStock() {
        return stockRepository.findAll();
    }

    @Transactional
    public Iterable<Chocolate> readChocolates() {
        return chocolateRepository.findAll();
    }

    @Override
    public Promocode getPromocodeByCode(String code) {
        return promocodeRepository.findByCode(code);
    }

    @Override
    public int getStockQuantityByChocolate(Chocolate chocolate) {
        return stockRepository.findStockByChocolate(chocolate).getQuantity();
    }

    @Override
    public Chocolate saveChocolate(Chocolate chocolate) {
        Chocolate save = chocolateRepository.save(chocolate);
        System.out.println(save);
        return save;
    }

    @Override
    public Optional<Chocolate> findChocolateById(long id) {
        return chocolateRepository.findById(id);
    }


}

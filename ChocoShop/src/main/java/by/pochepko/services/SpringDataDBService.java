package by.pochepko.services;

import by.pochepko.DAO.ChocolateCrudRepository;
import by.pochepko.DAO.PromocodeCrudRepository;
import by.pochepko.model.Chocolate;
import by.pochepko.model.PromoCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SpringDataDBService {

    @Autowired
    private PromocodeCrudRepository promocodeCrudRepository;
    @Autowired
    private ChocolateCrudRepository chocolateCrudRepository;


    @Transactional
    public Iterable<PromoCode> readPromocodes() {
        return promocodeCrudRepository.findAll();
    }

    @Transactional
    public Iterable<Chocolate> readChocolates() {
        return chocolateCrudRepository.findAll();
    }


}

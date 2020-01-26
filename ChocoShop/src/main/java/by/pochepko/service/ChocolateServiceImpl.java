package by.pochepko.service;

import by.pochepko.model.Chocolate;
import by.pochepko.repository.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ChocolateServiceImpl implements ChocolateService {

    @Autowired
    private ChocolateRepository chocolateRepository;

    @Override
    public List<Chocolate> getChocolateLst() {

        return StreamSupport.stream(chocolateRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public void updateChocolate(Chocolate chocolate) {
        chocolateRepository.save(chocolate);

    }

    @Override
    public Chocolate createChocolate(Chocolate chocolate) {

        return chocolateRepository.save(chocolate);
    }

    @Override
    public Chocolate getChocolateById(Long id) {

        return chocolateRepository.findById(id).get();
    }
}

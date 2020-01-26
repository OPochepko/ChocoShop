package by.pochepko.service;

import by.pochepko.model.Chocolate;

import java.util.List;

public interface ChocolateService {

    List<Chocolate> getChocolateLst();

    void updateChocolate(Chocolate chocolate);

    Chocolate createChocolate(Chocolate chocolate);

    Chocolate getChocolateById(Long id);

}

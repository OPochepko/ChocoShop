package by.pochepko.service;

import by.pochepko.model.Basket;

public interface OrderCalculator {

    int calculateOrderPrice(Basket basket);
}

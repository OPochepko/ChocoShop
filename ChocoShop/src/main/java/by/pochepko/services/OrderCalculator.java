package by.pochepko.services;

import by.pochepko.model.Basket;

public interface OrderCalculator {

    int calculateOrderPrice(Basket basket);
}

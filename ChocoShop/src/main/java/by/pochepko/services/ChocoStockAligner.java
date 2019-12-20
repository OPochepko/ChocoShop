package by.pochepko.services;

import by.pochepko.model.OrderLine;

public interface ChocoStockAligner {
    OrderLine alignOrderLineWithStock(OrderLine orderLine);
}

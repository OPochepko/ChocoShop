package by.pochepko.services;

import by.pochepko.OrderLine;

public interface ChocoStockAligner {
    OrderLine alignOrderLineWithStock(OrderLine orderLine);
}

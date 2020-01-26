package by.pochepko.service;

import by.pochepko.model.OrderLine;

public interface ChocoStockAligner {
    OrderLine alignOrderLineWithStock(OrderLine orderLine);
}

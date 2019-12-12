package by.pochepko.services;

import by.pochepko.OrderLine;
import by.pochepko.model.Chocolate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

public class DBChocoStockAligner implements ChocoStockAligner {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private HibernateDBService hibernateDBService;
    Map<Chocolate, Integer> chocoInStock = new HashMap<>();

    @Override
    public OrderLine alignOrderLineWithStock(OrderLine orderLine) {
        if (orderLine.getQuantity() > chocoInStock.get(orderLine.getChocolate())) {
            logger.debug("Not enough chocolate in stock, u want %d, but we have only %d. Quantity will be aligned with stock.",
                    orderLine.getQuantity(), chocoInStock.get(orderLine.getChocolate()));
            orderLine.setQuantity(chocoInStock.get(orderLine.getChocolate()));
        }
        return orderLine;
    }

    public void loadStock() {

    }
}

package by.pochepko.services;

import by.pochepko.model.OrderLine;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class DBChocoStockAligner implements ChocoStockAligner {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private DBService dbService;


    @Override
    public OrderLine alignOrderLineWithStock(OrderLine orderLine) {
        Validate.notNull(orderLine, "Order should not be NULL");
        int stockQuantity = dbService.getStockQuantityByChocolate(orderLine.getChocolate());

        logger.debug(String.format("OrderLine quantity =  %d, stockQuantity =  %d.", orderLine.getQuantity(), stockQuantity));

        if (orderLine.getQuantity() > dbService.getStockQuantityByChocolate(orderLine.getChocolate())) {
            logger.debug("Not enough chocolate in stock. Quantity will be aligned with stock.");
            orderLine.setQuantity(stockQuantity);
        }
        return orderLine;
    }
}

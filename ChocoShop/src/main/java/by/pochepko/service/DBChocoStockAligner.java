package by.pochepko.service;

import by.pochepko.model.OrderLine;
import by.pochepko.repository.StockRepository;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class DBChocoStockAligner implements ChocoStockAligner {

    @Autowired
    StockRepository stock;

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Override
    public OrderLine alignOrderLineWithStock(OrderLine orderLine) {
        Validate.notNull(orderLine, "Order should not be NULL");

        int stockQuantity = stock.findStockByChocolate(orderLine.getChocolate()).getQuantity();

        logger.debug(String.format("OrderLine quantity =  %d, stockQuantity =  %d.", orderLine.getQuantity(), stockQuantity));

        if (orderLine.getQuantity() > stockQuantity) {
            logger.debug("Not enough chocolate in stock. Quantity will be aligned with stock.");
            orderLine.setQuantity(stockQuantity);
        }
        return orderLine;
    }
}

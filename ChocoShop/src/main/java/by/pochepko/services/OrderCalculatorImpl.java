package by.pochepko.services;

import by.pochepko.model.Basket;
import by.pochepko.model.OrderLine;
import by.pochepko.model.Promocode;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class OrderCalculatorImpl implements OrderCalculator {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private TaxesCalculator taxesCalculator;
    @Autowired
    private PromocodeApplierFactory promocodeApplierFactory;

    @Autowired
    private DBService dbService;

    private PromocodeApplier promocodeApplier;

    @Override
    public int calculateOrderPrice(Basket basket) {
        Validate.notNull(basket, "The basket must not be %s", null);

        Promocode promocode = dbService.getPromocodeByCode(basket.getPromoCode());

        promocodeApplier = promocodeApplierFactory.getPromocodeApplier(promocode.getClass());

        int finalCost = 0;

        for (OrderLine orderLine : basket.getOrder()) {
            finalCost += taxesCalculator.calculateTaxes(orderLine.getTotalPrice());
        }

        finalCost = promocodeApplier.applyPromoCode(finalCost, promocode);
        logger.info("Basket: " + basket.toString() + "finalCost = " + finalCost);
        return finalCost;
    }
}

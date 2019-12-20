package by.pochepko.services.main;

import by.pochepko.model.Basket;
import by.pochepko.model.OrderLine;
import by.pochepko.services.OrderCalculator;
import by.pochepko.services.PromocodeApplier;
import by.pochepko.services.PromocodeApplierFactory;
import by.pochepko.services.TaxesCalculator;
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

    private PromocodeApplier promocodeApplier;

    @Override
    public int calculateOrderPrice(Basket basket) {
        Validate.notNull(basket, "The basket must not be %s", null);

        promocodeApplier = promocodeApplierFactory.getPromocodeApplier(basket.getPromoCode());

        int finalCost = 0;

        for (OrderLine orderLine : basket.getOrder()) {
            finalCost += taxesCalculator.calculateTaxes(orderLine.getTotalPrice());
        }

        finalCost = promocodeApplier.applyPromoCode(finalCost);
        logger.info("Basket: " + basket.toString() + "finalCost = " + finalCost);
        return finalCost;
    }
}

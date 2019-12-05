package by.pochepko.services;

import by.pochepko.Basket;
import by.pochepko.OrderLine;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
public class OrderCalculatorImpl implements OrderCalculator {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private TaxesCalculator taxesCalculator;
    private PromoCodeApplier promoCodeApplier;

    public OrderCalculatorImpl(TaxesCalculator taxesCalculator, PromoCodeApplier promoCodeApplier) {
        this.taxesCalculator = taxesCalculator;
        this.promoCodeApplier = promoCodeApplier;
        logger.info("OrderCalculatorCreated");
    }

    @Override
    public int calculateOrderPrice(Basket basket) {
        int finalCost = 0;

        Validate.notNull(basket, "The basket must not be %s", null);

        for (OrderLine orderLine : basket.getOrder()) {
            finalCost += taxesCalculator.calculateTaxes(orderLine.getTotalPrice());
        }
        finalCost = promoCodeApplier.applyPromoCode(basket.getPromoCode(), finalCost);
        logger.info("Basket: " + basket.toString() + "finalCost = " + finalCost);
        return finalCost;
    }
}

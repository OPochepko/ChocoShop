package by.pochepko.services;

import by.pochepko.Basket;
import by.pochepko.OrderLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderCalculatorImpl implements OrderCalculator {

    private Logger logger = LoggerFactory.getLogger(OrderCalculatorImpl.class);

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

        for (OrderLine orderLine : basket.getOrder()) {
            finalCost += taxesCalculator.calculateTaxes(orderLine.getTotalPrice());
        }
        finalCost = promoCodeApplier.applyPromoCode(basket.getPromoCode(), finalCost);
        logger.info("Basket: " + basket.toString() + "finalCost = " + finalCost);
        return finalCost;
    }
}

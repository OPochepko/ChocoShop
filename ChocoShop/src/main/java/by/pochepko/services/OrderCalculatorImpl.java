package by.pochepko.services;

import by.pochepko.Basket;
import by.pochepko.OrderLine;
import org.springframework.stereotype.Component;

@Component
public class OrderCalculatorImpl implements OrderCalculator {

    private TaxesCalculator taxesCalculator;
    private PromoCodeApplier promoCodeApplier;

    public OrderCalculatorImpl(TaxesCalculator taxesCalculator, PromoCodeApplier promoCodeApplier) {
        this.taxesCalculator = taxesCalculator;
        this.promoCodeApplier = promoCodeApplier;
        System.out.println("OrderCalculatorImpl is ready");
    }

    @Override
    public int calculateOrderPrice(Basket basket) {
        int finalCost = 0;

        for (OrderLine orderLine : basket.getOrder()) {
            finalCost += taxesCalculator.calculateTaxes(orderLine.getTotalPrice());
        }
        finalCost = promoCodeApplier.applyPromoCode(basket.getPromoCode(), finalCost);

        return finalCost;
    }
}

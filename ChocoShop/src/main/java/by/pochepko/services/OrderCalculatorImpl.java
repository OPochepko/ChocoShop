package by.pochepko.services;

import by.pochepko.Basket;
import by.pochepko.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderCalculatorImpl implements OrderCalculator{

    private TaxesCalculator taxesCalculator;

    private PromoCodeApplier promoCodeApplier;

    @Autowired
    public OrderCalculatorImpl(TaxesCalculator taxesCalculator, PromoCodeApplier promoCodeApplier) {
        this.taxesCalculator = taxesCalculator;
        this.promoCodeApplier = promoCodeApplier;
    }

    public int calculateOrderPrice(Basket basket){
        int finalCost = 0;

        for (OrderLine orderLine : basket.getOrder()){
            finalCost+= taxesCalculator.calculateTaxes(orderLine.getFullPrice());
        }
        finalCost = promoCodeApplier.applyPromoCode(basket.getPromoCode(),finalCost);

        return finalCost;
    }
}

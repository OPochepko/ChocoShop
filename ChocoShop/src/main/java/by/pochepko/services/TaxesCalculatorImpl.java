package by.pochepko.services;

import org.springframework.stereotype.Component;

@Component
public class TaxesCalculatorImpl implements TaxesCalculator {

    public int calculateTaxes(int price){
        return price > 100 ? (int) (price * 1.12) : price + 12;
    }
}

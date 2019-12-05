package by.pochepko.services;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
public class TaxesCalculatorImpl implements TaxesCalculator {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public TaxesCalculatorImpl() {
        logger.info("TaxesCalculator created");
    }


    @Override
    public int calculateTaxes(int price) {
        Validate.isTrue(price >= 0, "Price must be not negative: %d", price);
        int costAfterTaxes = (price > 100) ? (int) (price * 1.12) : price + 12;
        logger.info("price = " + price + " costAfterTaxes = " + costAfterTaxes);
        return costAfterTaxes;
    }
}

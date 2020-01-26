package by.pochepko.service;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class TaxesCalculatorImpl implements TaxesCalculator {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public TaxesCalculatorImpl() {
        logger.info("TaxesCalculator created");
    }


    @Override
    public int calculateTaxes(int price) {
        Validate.inclusiveBetween(0, Integer.MAX_VALUE, price, "Price must be not negative: %d", price);
        int costAfterTaxes = (price > 100) ? (int) (price * 1.12) : price + 12;
        logger.info("price = " + price + " costAfterTaxes = " + costAfterTaxes);
        return costAfterTaxes;
    }
}

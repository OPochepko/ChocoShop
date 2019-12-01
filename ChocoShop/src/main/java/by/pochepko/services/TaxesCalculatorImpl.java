package by.pochepko.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TaxesCalculatorImpl implements TaxesCalculator {

    private Logger logger = LoggerFactory.getLogger(PromoCodeApplierImpl.class);

    public TaxesCalculatorImpl() {
        logger.info("TaxesCalculator created");
    }


    @Override
    public int calculateTaxes(int price) {
        int costAfterTaxes = (price > 100) ? (int) (price * 1.12) : price + 12;
        logger.info("price = " + price + " costAfterTaxes = " + costAfterTaxes);
        return costAfterTaxes;
    }
}

package by.pochepko.services;

import by.pochepko.model.PercentDiscountPromocode;
import by.pochepko.model.Promocode;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class PercentDiscountPromocodeApplier implements PromocodeApplier {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Override
    public int applyPromoCode(int cost, Promocode promocode) {
        PercentDiscountPromocode percentDiscountPromocode = (PercentDiscountPromocode) promocode;

        Validate.inclusiveBetween(0, Integer.MAX_VALUE, cost, "Cost must be not negative: %d", cost);

        if (promocode == null) {
            logger.info("promocode = NULL");
            return cost;
        } else {
            int costWithPromo = cost * (100 - percentDiscountPromocode.getPercentDiscount()) / 100;
            logger.info("promocode =" + promocode);
            return costWithPromo;
        }

    }

    @Override
    public Class<? extends Promocode> compitableWith() {
        return PercentDiscountPromocode.class;
    }
}

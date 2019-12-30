package by.pochepko.services;

import by.pochepko.model.FixDiscontPromocode;
import by.pochepko.model.Promocode;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class FixDiscountPromocodeApplier implements PromocodeApplier {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Override
    public int applyPromoCode(int cost, Promocode promocode) {
        FixDiscontPromocode fixDiscontPromocode = (FixDiscontPromocode) promocode;
        Validate.inclusiveBetween(0, Integer.MAX_VALUE, cost, "Cost must be not negative: %d", cost);

        if (fixDiscontPromocode == null) {
            logger.info("promocode = NULL");
            return cost;
        } else {
            logger.info("promocode =" + fixDiscontPromocode);
            int costWithPromo = cost - fixDiscontPromocode.getFixDiscount();
            return costWithPromo;
        }
    }

    @Override
    public Class<? extends Promocode> compitableWith() {
        return FixDiscontPromocode.class;
    }

}

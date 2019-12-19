package by.pochepko.services.main;

import by.pochepko.model.FixDiscontPromocode;
import by.pochepko.model.Promocode;
import by.pochepko.services.PromocodeApplier;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;

@Service
public class FixDiscountPromocodeApplier implements PromocodeApplier {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private FixDiscontPromocode promocode;

    @Override
    public int applyPromoCode(int cost) {
        Validate.inclusiveBetween(0, Integer.MAX_VALUE, cost, "Cost must be not negative: %d", cost);

        if (promocode == null) {
            logger.info("promocode = NULL");
            return cost;
        } else {
            logger.info("promocode =" + promocode);
            int costWithPromo = cost * -promocode.getFixDiscount();
            return costWithPromo;
        }
    }

    public void setPromocode(Promocode promocode) {
        this.promocode = (FixDiscontPromocode) promocode;
    }
}

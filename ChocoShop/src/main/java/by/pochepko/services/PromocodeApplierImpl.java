package by.pochepko.services;

import by.pochepko.model.PromoCode;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

public class PromocodeApplierImpl implements PromoCodeApplier {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    protected Map<String, PromoCode> promocodes = new HashMap<>();

    @Override
    public int applyPromoCode(String code, int cost) {

        Validate.inclusiveBetween(0, Integer.MAX_VALUE, cost, "Cost must be not negative: %d", cost);

        PromoCode promoCode = promocodes.get(code);

        if (promoCode == null) {
            logger.info("promocode = NULL");
            return cost;
        } else {
            int costWithPromo = cost * (100 - promoCode.getPercentDiscount()) / 100 - promoCode.getFixDiscount();
            logger.info("promocode =" + promoCode);
            return costWithPromo;
        }
    }

}

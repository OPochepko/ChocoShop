package by.pochepko.services.main;

import by.pochepko.model.PromoCode;
import by.pochepko.services.DBService;
import by.pochepko.services.PromoCodeApplier;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.invoke.MethodHandles;

public class DBPromocodeApplier implements PromoCodeApplier {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private DBService dbService;

    @Override
    public int applyPromoCode(String code, int cost) {
        Validate.inclusiveBetween(0, Integer.MAX_VALUE, cost, "Cost must be not negative: %d", cost);

        PromoCode promoCode = dbService.getPromocodeByCode(code);

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

package by.pochepko.services;

import by.pochepko.PromoCode;
import by.pochepko.PromoCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
public class PromoCodeApplierImpl implements PromoCodeApplier {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private PromoCodes promoCodes;

    public PromoCodeApplierImpl(PromoCodes promoCodes) {
        this.promoCodes = promoCodes;
        logger.info("PromocodeApplier Created");
    }

    @Override
    public int applyPromoCode(String code, int cost) {

        PromoCode promoCode = promoCodes.get(code);

        if (promoCode == null) {
            logger.info("promocode = NULL");
            return cost;
        }
        else {
            int costWithPromo = cost * (100 - promoCode.getPercentDiscount()) / 100 - promoCode.getFixDiscount();
            logger.info("promocode =" + promoCode);
            return costWithPromo;
        }

    }
}

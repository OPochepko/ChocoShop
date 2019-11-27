package by.pochepko.services;

import by.pochepko.PromoCode;
import by.pochepko.PromoCodes;
import org.springframework.stereotype.Component;

@Component
public class PromoCodeApplierImpl implements PromoCodeApplier {

    private PromoCodes promoCodes;

    public PromoCodeApplierImpl(PromoCodes promoCodes) {
        this.promoCodes = promoCodes;
    }

    public int applyPromoCode(String code, int cost) {

        PromoCode promoCode = promoCodes.get(code);

        if (promoCode == null) return cost;
        else {

            int costWithPromo = cost * (100 - promoCode.getPercentDiscount()) / 100 - promoCode.getFixDiscount();
            return costWithPromo;

        }

    }
}

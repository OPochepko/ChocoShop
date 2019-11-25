package by.pochepko.services;

import by.pochepko.PromoCodes;
import org.springframework.stereotype.Component;

@Component
public class PromoCodeApplierImpl implements PromoCodeApplier{

    public int applyPromoCode(PromoCodes code, int cost){

        int costWithPromo = cost * (100 - code.getPercentDiscount())/100 - code.getFixDiscount(); ;

        return costWithPromo;
    }
    }

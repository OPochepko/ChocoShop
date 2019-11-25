package by.pochepko.services;

import by.pochepko.PromoCodes;

public interface PromoCodeApplier {
    public int applyPromoCode(PromoCodes code, int cost);
}

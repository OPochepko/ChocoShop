package by.pochepko.services;

import by.pochepko.model.Promocode;

public interface PromocodeApplier {
    int applyPromoCode(int cost);

    void setPromocode(Promocode promocode);

}

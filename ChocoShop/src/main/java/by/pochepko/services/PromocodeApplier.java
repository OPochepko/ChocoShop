package by.pochepko.services;

import by.pochepko.model.Promocode;

public interface PromocodeApplier {
    int applyPromoCode(int cost, Promocode promocode);

    Class<? extends Promocode> compitableWith();

}

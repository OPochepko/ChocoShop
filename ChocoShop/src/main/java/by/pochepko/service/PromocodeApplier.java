package by.pochepko.service;

import by.pochepko.model.Promocode;

public interface PromocodeApplier {
    int applyPromoCode(int cost, Promocode promocode);

    Class<? extends Promocode> compitableWith();

}

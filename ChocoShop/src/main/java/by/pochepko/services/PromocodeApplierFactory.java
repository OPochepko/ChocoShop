package by.pochepko.services;

import by.pochepko.model.Promocode;

public interface PromocodeApplierFactory {
    <P extends Promocode> PromocodeApplier getPromocodeApplier(Class<P> promocodeClazz);
}

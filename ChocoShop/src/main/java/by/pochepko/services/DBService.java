package by.pochepko.services;

import by.pochepko.PromoCode;

import java.util.List;

public interface DBService {
    List<PromoCode> readPromocodes();
}

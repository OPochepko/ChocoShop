package by.pochepko.services;

import by.pochepko.model.PromoCode;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DBService {
    @Transactional
    List<PromoCode> readPromocodes();
}

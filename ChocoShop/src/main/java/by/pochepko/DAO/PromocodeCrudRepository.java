package by.pochepko.DAO;

import by.pochepko.model.PromoCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocodeCrudRepository extends CrudRepository<PromoCode, Integer> {
    PromoCode findByCode(String code);
}

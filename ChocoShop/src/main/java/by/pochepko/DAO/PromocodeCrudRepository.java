package by.pochepko.DAO;

import by.pochepko.model.Promocode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocodeCrudRepository extends CrudRepository<Promocode, Integer> {
    Promocode findByCode(String code);
}

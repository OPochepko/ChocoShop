package by.pochepko.repository;

import by.pochepko.model.Promocode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocodeRepository extends CrudRepository<Promocode, Long> {
    Promocode findByCode(String code);
}

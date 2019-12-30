package by.pochepko.dao;

import by.pochepko.model.Chocolate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChocolateRepository extends CrudRepository<Chocolate, Long> {
}

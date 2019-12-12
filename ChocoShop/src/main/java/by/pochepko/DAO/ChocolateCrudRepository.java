package by.pochepko.DAO;

import by.pochepko.model.Chocolate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChocolateCrudRepository extends CrudRepository<Chocolate, Integer> {
}

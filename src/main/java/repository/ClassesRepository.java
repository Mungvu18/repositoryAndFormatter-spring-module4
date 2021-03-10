package repository;

import model.Classess;
import org.springframework.data.repository.CrudRepository;

public interface ClassesRepository extends CrudRepository<Classess,Long> {
    Classess findByName(String name);
}

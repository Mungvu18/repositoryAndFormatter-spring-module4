package repository;

import model.Classess;
import model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
    Iterable<Student> findAllByNameContaining (String name);
    Iterable<Student> findAllByClassess(Classess classes);
}

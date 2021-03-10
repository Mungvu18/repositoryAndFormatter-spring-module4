package service.classes;

import model.Classess;
import org.springframework.beans.factory.annotation.Autowired;
import repository.ClassesRepository;

public class ClassesService implements IClassesService{
    @Autowired
    private ClassesRepository classesRepository;
    @Override
    public Iterable<Classess> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Classess findById(Long id) {
        return classesRepository.findOne(id);
    }

    @Override
    public void update(Classess model) {

    }

    @Override
    public void save(Classess model) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Classess findByName(String name) {
        return classesRepository.findByName(name);
    }
}

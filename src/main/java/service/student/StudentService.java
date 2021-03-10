package service.student;

import model.Classess;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import repository.StudentRepository;

public class StudentService implements IStudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public void update(Student model) {
        studentRepository.save(model);
    }

    @Override
    public void save(Student model) {
    }

    @Override
    public void remove(Long id) {
        studentRepository.delete((id));
    }

    @Override
    public Iterable<Student> listFindByName(String name) {
        return studentRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Student> findAllByClassess(Classess classes) {
        return studentRepository.findAllByClassess(classes);
    }
}

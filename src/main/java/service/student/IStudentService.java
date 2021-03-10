package service.student;

import model.Classess;
import model.Student;
import service.IService;

public interface IStudentService extends IService<Student>{
    Iterable<Student> listFindByName (String name);
    Iterable<Student> findAllByClassess(Classess classes);
}

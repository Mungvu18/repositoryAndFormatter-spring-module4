package service.classes;

import model.Classess;
import service.IService;

public interface IClassesService extends IService<Classess> {
    Classess findByName(String name);
}

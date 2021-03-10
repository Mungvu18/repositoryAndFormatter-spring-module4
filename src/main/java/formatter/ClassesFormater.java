package formatter;

import model.Classess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import service.classes.IClassesService;

import java.text.ParseException;
import java.util.Locale;

public class ClassesFormater implements Formatter<Classess> {
    @Autowired
    private IClassesService classesService;
    public ClassesFormater(IClassesService classesService) {
        this.classesService = classesService;
    }

    @Override
    public Classess parse(String text, Locale locale) throws ParseException {
        return classesService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Classess object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() +"]" ;
    }
}

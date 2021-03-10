package controller;

import model.Classess;
import model.Student;
import model.StudentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.classes.IClassesService;
import service.student.IStudentService;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private Environment environment;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClassesService classesService;
    // lấy biến classes dùng chung cho view
    @ModelAttribute("classesList")
    public Iterable<Classess> classesses(){
        return classesService.findAll();
    }
    @GetMapping()
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("student/list");
        modelAndView.addObject("list",studentService.findAll());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("student/edit");
        Student student = studentService.findById(id);
        modelAndView.addObject("s",student);
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView editStudent(@ModelAttribute Student student){
       ModelAndView modelAndView = new ModelAndView("/student/edit");
       studentService.update(student);
       modelAndView.addObject("mess","done edit");
       return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student",new StudentForm());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createStudent(@ModelAttribute StudentForm studentForm){
        // gán student nhưng thuộc tính là của studentForm
        MultipartFile file = studentForm.getImage();
        String image = file.getOriginalFilename();
        String fileUpload = environment.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(file.getBytes(),new File(fileUpload+image));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student student = new Student(studentForm.getName(),studentForm.getAddress(),image,studentForm.getClassess());
        studentService.update(student);
        return new ModelAndView("/student/create","student",new StudentForm());
    }
    @PostMapping("/search")
    public ModelAndView search(@ModelAttribute Classess classess){
        ModelAndView modelAndView = new ModelAndView("/student/list");
        modelAndView.addObject("list",studentService.findAllByClassess(classess));
        return modelAndView;
    }
}

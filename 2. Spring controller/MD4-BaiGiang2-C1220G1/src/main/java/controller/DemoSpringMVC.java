package controller;

import model.Language;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.StudentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DemoSpringMVC {
    private StudentServiceImpl studentService = new StudentServiceImpl();
    public String hello(HttpServletRequest request){
        Student student = new Student();
        student.setName("Tuyen");
        student.setAddress("Ha Noi");
        Language language = new Language();
        language.setName("JAVA");
        student.setLanguage(language);
        request.setAttribute("student",student);
        return "/demo";
    }
@RequestMapping("/")
    public String listStudent(HttpServletRequest request){
    List<Student> students = studentService.findAll();
    request.setAttribute("students",students);
        return "/list";
}
@GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id, HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("/detail");
        System.out.println("id ====== "+id);
        Student student = studentService.findById(id);
        modelAndView.addObject("student",student);
        return modelAndView;
}

}

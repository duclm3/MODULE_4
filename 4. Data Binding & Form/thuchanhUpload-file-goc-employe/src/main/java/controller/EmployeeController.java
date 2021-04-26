package controller;

import model.Employee;
import model.EmployeeForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.IEmployeeService;
import service.EmployeeServiceImpl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final IEmployeeService productService = new EmployeeServiceImpl();
    @Value("${file-save}")
    private String fileSave;

    @GetMapping("")
    public String index(Model model) {
        List<Employee> employees = productService.findAll();
        model.addAttribute("employees", employees);
        return "/index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employeeForm", new EmployeeForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute EmployeeForm employeeForm) {
        MultipartFile multipartFile = employeeForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(employeeForm.getAvatar().getBytes(), new File(fileSave + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Employee employee = new Employee(employeeForm.getId(),employeeForm.getName(),
                employeeForm.getDate(),fileName,employeeForm.getGender());
        productService.save(employee);
        System.out.println(employee.getDate());
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employeeForm", employeeForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
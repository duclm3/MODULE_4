package com.controller;

import com.model.Employee;
import com.model.EmployeeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.service.IEmployeeService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Value("${file-save}")
    private String fileSave;

    @GetMapping
    public String index(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "/index";
    }

    @GetMapping("/viewCreate")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employeeForm", new EmployeeForm());
        return modelAndView;
    }
    @GetMapping("/viewEdit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("employeeForm", employee);
        return modelAndView;
    }

    @PostMapping("/createOrEdit")
    public ModelAndView saveProduct(@ModelAttribute EmployeeForm employeeForm) {
        MultipartFile multipartFile = null;
        String fileName = null;
        try {
            multipartFile = employeeForm.getAvatar();
            fileName = multipartFile.getOriginalFilename();
            FileCopyUtils.copy(employeeForm.getAvatar().getBytes(), new File(fileSave + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Employee employee = new Employee(employeeForm.getId(),employeeForm.getName(),
                employeeForm.getDate(), fileName,employeeForm.getGender());
        employeeService.saveOrUpdate(employee);
        System.out.println(employee.getDate());
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("employeeForm", employee);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        employeeService.remove(id);
        return "redirect:/employee";
    }
}
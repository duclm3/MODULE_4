package controller;

import model.Blog;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.BlogService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/")
    public ModelAndView listCustomer(){
        List<Blog> blogList = blogService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("blogList",blogList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/add");
        modelAndView.addObject("createForm",new Blog());
        return modelAndView;
    }
    @PostMapping("/create/customer")
    public String createCustomer(@ModelAttribute("createForm")Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("editForm",blog);
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute("editForm") Blog customer){
        blogService.save(customer);
        return "redirect:/";
    }
    @GetMapping("/detail/{id}")
    public ModelAndView detailCustomer(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("detailCustomer",blog);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable Long id){
        Blog blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("deleteForm",blog);
        return modelAndView;
    }
    @PostMapping("/delete/customer")
    public String deleteCustomer(@ModelAttribute("deleteForm") Blog blog){
        blogService.delete(blog.getId());
        return "redirect:/";
    }
}

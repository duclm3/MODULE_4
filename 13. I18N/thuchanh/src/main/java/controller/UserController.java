package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("/login");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView doLogin(@ModelAttribute("user") User user){
        if(user.getUsername().equals("ozawa")&&user.getPassword().equals("123")){
            return new ModelAndView("/success");
        }
        return new ModelAndView("/error");
    }

}

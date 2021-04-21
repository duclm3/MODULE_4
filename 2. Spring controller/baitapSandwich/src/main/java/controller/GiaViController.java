package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GiaViController {
    @GetMapping("/giavi")
    public String getGiaVi(@RequestParam("condiment") String[] condiment, Model model){
        model.addAttribute("condiments",condiment);
        return "index";
    }
}

package controller;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    @GetMapping("/create-setting")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("setting", new Setting());
        modelAndView.addObject("languageArray", new String[]{"English", "Vietnamese", "Japanese", "Chinese",});
        modelAndView.addObject("pageSizeArray", new String[]{"5", "10", "15", "25", "50", "100"});
        return modelAndView;
    }

    @PostMapping("/create-setting")
    public ModelAndView createSetting(@ModelAttribute("setting") Setting setting){
        ModelAndView modelAndView = new ModelAndView("/show");
        modelAndView.addObject("setting", setting);
        return modelAndView;

    }
}

package com.codegym.wdbsspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping()
public class AboutController {
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}

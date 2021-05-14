package com.codegym.wdbsspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class SecController {
    @GetMapping("/khongcoquyen")
    public String accessDenied(){
        return "khongcoquyen";
    }
    @GetMapping("/admin")
    public String adminHome(){
        return "admin";
    }
    @GetMapping("/user")
    public String userHome(){
        return "user";
    }
}

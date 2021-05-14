package com.codegym.wdbsspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @GetMapping("/")
    public String categories(){
        return "category";
    }
}

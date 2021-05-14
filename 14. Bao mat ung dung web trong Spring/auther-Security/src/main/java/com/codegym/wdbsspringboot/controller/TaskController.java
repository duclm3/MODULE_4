package com.codegym.wdbsspringboot.controller;

import com.codegym.wdbsspringboot.model.Task;
import com.codegym.wdbsspringboot.service.taskservice.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private ITaskService taskService;

    @GetMapping()
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("/task/list");
        List<Task> tasks = (List<Task>) taskService.findAll();
        modelAndView.addObject("tasks", tasks);
        modelAndView.addObject("mess", "Xin chao");
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/task/create");
        modelAndView.addObject("task", new Task());
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView creatTask(@ModelAttribute Task task){
        taskService.save(task);
        return new RedirectView("");
    }
}

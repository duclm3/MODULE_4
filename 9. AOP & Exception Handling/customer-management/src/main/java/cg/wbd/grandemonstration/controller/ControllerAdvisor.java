package cg.wbd.grandemonstration.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handle(Exception ex, WebRequest request) {
        ModelAndView mv = new ModelAndView("/customers/404");
        mv.addObject("message", ex.getMessage());
        mv.setViewName("404");
        return mv;
    }
}
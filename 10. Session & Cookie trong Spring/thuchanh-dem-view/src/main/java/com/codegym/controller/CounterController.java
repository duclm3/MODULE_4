package com.codegym.controller;

import com.codegym.model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("counter") //Annotation @SessionAttributes("counter") được sử dụng để lưu trữ model attribute trong session
public class CounterController {
    //model attribute "counter"  sẽ được thêm vào session nếu tên attribute của @ModelAttribute và @SessionAttributes giống nhau.
    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    //Annotation @ModelAttribute liên kết một tham số phương thức hoặc một phương thức
    // trả về giá trị cho một model attribute và sau đó trả nó về một view cụ thể.
    @GetMapping("/")
    public String get(@ModelAttribute("counter") Counter counter) {
        counter.increment();
        return "/index";
    }
}

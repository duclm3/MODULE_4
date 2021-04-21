package controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {
    @RequestMapping(value = "/hello",produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(){
        return "Goodbye World!";
    }
}

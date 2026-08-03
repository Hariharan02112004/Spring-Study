package com.example.SpringSecurity1.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {
    @GetMapping("hello")
    public String controller1(){
        return "hello da thambi";
    }
}

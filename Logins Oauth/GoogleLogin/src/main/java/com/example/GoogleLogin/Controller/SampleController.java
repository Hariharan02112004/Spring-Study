package com.example.GoogleLogin.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("hello")
    public String greetFirst(){
        return "Vanakam da thambi";
    }
    @GetMapping("hello2")
    public String greetTwo(){
        return "Vanakam da mapla";
    }
}

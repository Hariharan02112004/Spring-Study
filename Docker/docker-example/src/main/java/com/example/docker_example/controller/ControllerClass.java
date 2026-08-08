package com.example.docker_example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {
    @RequestMapping("/")
    public String greetings(){
        return "Muruga.........";
    }
    @RequestMapping("/heyy")
    public String methodDa(){
        return "Aaru mugam";
    }
}

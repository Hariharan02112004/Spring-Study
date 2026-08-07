package com.microservice.service_B.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceB")
public class serviceBController {

    @GetMapping("/getServiceB")
    public String getMethodB(){
        return "Service B bruh.....";
    }
}

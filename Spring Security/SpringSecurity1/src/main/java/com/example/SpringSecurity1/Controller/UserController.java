package com.example.SpringSecurity1.Controller;

import com.example.SpringSecurity1.Model.User;
import com.example.SpringSecurity1.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private userService service;
    @PostMapping("registerUser")
    public User addNewUser(@RequestBody User user){
        return service.addUser(user);
    }
}

package com.example.SpringSecurity1.Controller;

import com.example.SpringSecurity1.Model.User;
import com.example.SpringSecurity1.Service.JwtService;
import com.example.SpringSecurity1.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private userService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("registerUser")
    public User addNewUser(@RequestBody User user){
        return service.addUser(user);
    }
    @PostMapping("Login")
    public String login(@RequestBody User user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())return jwtService.generateToken(user.getUsername());
        return "Failed to login";
    }
}

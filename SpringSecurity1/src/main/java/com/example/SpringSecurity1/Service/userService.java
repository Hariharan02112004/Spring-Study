package com.example.SpringSecurity1.Service;

import com.example.SpringSecurity1.Model.User;
import com.example.SpringSecurity1.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private userRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}

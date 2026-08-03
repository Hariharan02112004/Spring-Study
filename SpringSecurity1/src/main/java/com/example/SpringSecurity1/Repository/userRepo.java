package com.example.SpringSecurity1.Repository;

import com.example.SpringSecurity1.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
package com.example.SpringSecurity.Repository;

import com.example.SpringSecurity.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}

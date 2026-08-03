package com.example.SpringSecurity1.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    private int id;
    private String username;
    private String password;
}
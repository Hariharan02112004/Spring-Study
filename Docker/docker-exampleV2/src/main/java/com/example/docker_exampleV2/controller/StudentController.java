package com.example.docker_exampleV2.controller;

import com.example.docker_exampleV2.entity.Student;
import com.example.docker_exampleV2.repository.StudentRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class StudentController {
    private final StudentRepo studentRepo;
    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    @GetMapping("/getStu")
    public List<Student> getAll(){
        return studentRepo.findAll();
    }
}

package com.example.SpringSecurity1.Controller;

import com.example.SpringSecurity1.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> list = new ArrayList<>(
            List.of(
                    new Student(3,"Hariharan","8"),
                    new Student(4,"Rani","8")
            )
    );
    @GetMapping("AllStudents")
    public List<Student> getStu(){
        return list;
    }

    @PostMapping("addStu")
    public void addStudent(@RequestBody Student s){
        list.add(s);
    }
}


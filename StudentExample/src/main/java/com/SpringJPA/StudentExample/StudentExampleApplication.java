package com.SpringJPA.StudentExample;

import com.SpringJPA.StudentExample.Model.Student;
import com.SpringJPA.StudentExample.Service.StudentService;
import com.SpringJPA.StudentExample.util.StudentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class StudentExampleApplication implements CommandLineRunner {

    @Autowired
    private StudentUtil studentUtil;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(StudentExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Student s1 = studentUtil.createStudent(context, 1, "Arun", 85, "Chennai");
        Student s2 = studentUtil.createStudent(context, 2, "Priya", 90, "Coimbatore");
        Student s3 = studentUtil.createStudent(context, 3, "Rahul", 75, "Madurai");
        Student s4 = studentUtil.createStudent(context, 4, "Sneha", 88, "Trichy");
        Student s5 = studentUtil.createStudent(context, 5, "Vikram", 92, "Salem");
        studentService.saveMethod(s1);
        studentService.saveMethod(s2);
        studentService.saveMethod(s3);
        studentService.saveMethod(s4);
        studentService.saveMethod(s5);
        System.out.println(studentService.getAll());
        System.out.println();
        Optional<Student> optional = studentService.getOne(5);
        System.out.println(optional.orElse(new  Student()));
        Student student = optional.orElse(new  Student());
        student.setStuMarks(100);
        studentService.saveMethod(student);
        int delId=student.getStuId();
        System.out.println("After Update: ");
        System.out.println(studentService.getAll());
        studentService.deleteStudent(delId);
        System.out.println("After delete: ");
        System.out.println(studentService.getAll());


    }
}
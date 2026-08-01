package com.SpringStudy2.Spring.StudentJDBC;

import com.SpringStudy2.Spring.StudentJDBC.Model.Student;
import com.SpringStudy2.Spring.StudentJDBC.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class StudentJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentJdbcApplication.class, args);
        Student s1= context.getBean(Student.class);
        s1.setRollNo(1);
        s1.setMarks(59);
        s1.setName("Krishna");
        StudentService studentService = context.getBean(StudentService.class);
        studentService.addStudent(s1);
        List<Student> allStu = studentService.getAll();
        System.out.println(allStu);
	}
}

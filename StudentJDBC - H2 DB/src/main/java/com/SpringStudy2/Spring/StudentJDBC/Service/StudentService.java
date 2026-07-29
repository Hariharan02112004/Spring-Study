package com.SpringStudy2.Spring.StudentJDBC.Service;

import com.SpringStudy2.Spring.StudentJDBC.Model.Student;
import com.SpringStudy2.Spring.StudentJDBC.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo stuRepo;

    public StudentRepo getStuRepo() {
        return stuRepo;
    }
    @Autowired
    public void setStuRepo(StudentRepo stuRepo) {
        this.stuRepo = stuRepo;
    }

    public void addStudent(Student student){
            stuRepo.save(student);
    }

    public List<Student> getAll() {
        return stuRepo.findAll();
    }
}

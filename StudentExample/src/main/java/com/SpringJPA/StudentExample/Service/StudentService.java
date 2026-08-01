package com.SpringJPA.StudentExample.Service;

import com.SpringJPA.StudentExample.Model.Student;
import com.SpringJPA.StudentExample.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public void saveMethod(Student s) {
        studentRepository.save(s);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> getOne(int i) {
        return studentRepository.findById(i);
    }

    public void deleteStudent(int delId) {
        studentRepository.deleteById(delId);
    }
}

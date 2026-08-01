package com.SpringJPA.StudentExample.util;

import com.SpringJPA.StudentExample.Model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StudentUtil {
    public Student createStudent(ApplicationContext context, int id, String name, int marks, String address) {

        Student s = context.getBean(Student.class);
        s.setStuId(id);
        s.setStuName(name);
        s.setStuMarks(marks);
        s.setStuAddress(address);
        return s;
    }
}

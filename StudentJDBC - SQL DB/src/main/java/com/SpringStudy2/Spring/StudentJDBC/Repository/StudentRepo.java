package com.SpringStudy2.Spring.StudentJDBC.Repository;

import com.SpringStudy2.Spring.StudentJDBC.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student student) {
        String insQuery="INSERT INTO studentDetails (rollNo, StuName, Marks) VALUES (?,?,?)";
        int res = jdbc.update(insQuery,student.getRollNo(),student.getName(),student.getMarks());
        if(res>0){
            System.out.println("Student Details has been saved successfully");
        }else{
            System.out.println("Student Details could not be saved");
        }
    }

    public List<Student> findAll() {
        String SelQuery="SELECT * FROM studentDetails;";
        RowMapper<Student> mapper = (rs, rowNum) -> {
                Student s = new Student();
                s.setRollNo(rs.getInt("rollNo"));
                s.setName(rs.getString("StuName"));
                s.setMarks(rs.getInt("Marks"));
                return s;
            };
        return jdbc.query(SelQuery,mapper);
    }
}

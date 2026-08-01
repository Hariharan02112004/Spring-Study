package com.SpringStudy2.Spring.Repository;

import com.SpringStudy2.Spring.Models.Laptop;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class RepositoryLayer {
    public void insertMethod(Laptop lap) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/SpringDB";
        String uname = "root";
        String pass = "harikodi0220";
        Connection con = DriverManager.getConnection(url,uname,pass);
        String insQuery="insert into laptopDetails values(?,?,?,?,?)";
        PreparedStatement pt =con.prepareStatement(insQuery);
        pt.setInt(1,lap.getLapID());
        pt.setString(2,lap.getLapName());
        pt.setString(3,lap.getLapProcessor());
        pt.setInt(4,lap.getLapHardDisk());
        pt.setString(5,lap.getLapKeyboard());
        if(pt.executeUpdate()>0){
            System.out.println("Laptop inserted successfully");
        }else{
            System.out.println("Laptop insertion failed");
        }
        pt.close();
        con.close();
    }
}

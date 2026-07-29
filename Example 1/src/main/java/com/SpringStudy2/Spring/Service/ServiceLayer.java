package com.SpringStudy2.Spring.Service;

import com.SpringStudy2.Spring.Models.Laptop;
import com.SpringStudy2.Spring.Repository.RepositoryLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ServiceLayer {

    @Autowired
    private RepositoryLayer repositoryLayer;
    public void CheckLap(Laptop lap) throws SQLException {
            repositoryLayer.insertMethod(lap);

    }
}

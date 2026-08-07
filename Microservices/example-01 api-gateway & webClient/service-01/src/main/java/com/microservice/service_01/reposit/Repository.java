package com.microservice.service_01.reposit;


import com.microservice.service_01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User, Integer> {
}

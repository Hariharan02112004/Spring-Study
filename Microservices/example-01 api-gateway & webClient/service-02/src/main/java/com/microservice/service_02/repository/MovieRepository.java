package com.microservice.service_02.repository;

import com.microservice.service_02.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByUserId(int userId);

}
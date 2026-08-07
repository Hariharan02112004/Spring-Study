package com.microservice.service_02.controller;

import com.microservice.service_02.service.MovieService;
import com.microservice.service_02.dto.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;
    @Value("${server.port}")
    private String port;

    @GetMapping("/user/{userId}")
    public List<MovieDTO> getMovies(
            @PathVariable int userId) {
        System.out.println("Running on port: " + port);
        return service.getMovies(userId);
    }
}

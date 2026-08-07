package com.microservice.service_01.service;

import com.microservice.service_01.dto.MovieDTO;
import com.microservice.service_01.dto.userDTO;
import com.microservice.service_01.model.User;
import com.microservice.service_01.reposit.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service01 {

    private final Repository repo;

    private final WebClient.Builder webclientBuilder;

    public userDTO getUser(int userId) {
        User user = repo.findById(userId)
                .orElseThrow(()->new RuntimeException("User Not Found"));

        List<MovieDTO> movies = webclientBuilder
                .build()
                .get()
                .uri("http://SERVICE-02/movies/user/" + userId)
                .retrieve()
                .bodyToFlux(MovieDTO.class)
                .collectList()
                .block();

        return new userDTO(userId,user.getUserName(),movies);

    }
}

package com.microservice.service_01.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class userDTO {
    int userId;
    String userName;
    List<MovieDTO> movies;
}

package com.microservice.service_02.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    private int userId;

    private String movieName;

    private int rating;
}

package com.microservice.service_02.service;

import com.microservice.service_02.dto.MovieDTO;
import com.microservice.service_02.model.Movie;
import com.microservice.service_02.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repo;

    public List<MovieDTO> getMovies(int userId) {
        List<Movie> movieList = repo.findByUserId(userId);

        List<MovieDTO> movieDTOList = new ArrayList<>();

        for (Movie movie : movieList) {
            MovieDTO dto = new MovieDTO();

            dto.setMovieId(movie.getMovieId());
            dto.setMovieName(movie.getMovieName());
            dto.setRating(movie.getRating());

            movieDTOList.add(dto);
        }

        return movieDTOList;
    }
}

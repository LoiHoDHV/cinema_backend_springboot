package com.example.cinema_3.Repositories;

import com.example.cinema_3.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Optional<Movie> findMovieByMovieId(Long movieId);

}

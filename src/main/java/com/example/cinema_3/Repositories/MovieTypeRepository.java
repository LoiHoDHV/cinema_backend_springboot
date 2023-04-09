package com.example.cinema_3.Repositories;

import com.example.cinema_3.domain.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTypeRepository extends JpaRepository<MovieType, Long> {

    public MovieType findMovieTypeByTypeName(String name);
}

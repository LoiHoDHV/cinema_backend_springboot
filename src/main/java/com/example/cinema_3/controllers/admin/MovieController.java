package com.example.cinema_3.controllers.admin;


import com.example.cinema_3.Services.MovieServices;
import com.example.cinema_3.domain.Movie;
import com.example.cinema_3.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin/movies")
@CrossOrigin("*")
public class MovieController {

    @Autowired
    MovieServices movieServices;


    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody MovieDTO movieDTO){
        System.out.println();

        return ResponseEntity.ok(movieServices.save(movieDTO));
    }

    @GetMapping
    public ResponseEntity<?> gettAllMovie(){
        System.out.println();
        return ResponseEntity.ok(movieServices.findAll());
    }

    @GetMapping(value = "{movieID}")
    public ResponseEntity<?> getDetailsMovies(@PathVariable Long movieID){

        Optional<Movie> movie = movieServices.findById(movieID);

        return ResponseEntity.ok(movie.orElse(null));
    }

    @PutMapping(value = "{movieID}")
    public void updateMovie(@PathVariable Long movieID, @RequestBody MovieDTO movieDTO){
        movieServices.updateMovieById(movieID,movieDTO);
    }

    @DeleteMapping(value = "{movieID}")
    public void deleteMovie(@PathVariable Long movieID){
        movieServices.deleteById(movieID);
    }


}

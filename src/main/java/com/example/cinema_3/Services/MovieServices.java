package com.example.cinema_3.Services;


import com.example.cinema_3.Repositories.ActorRepository;
import com.example.cinema_3.Repositories.CategoryRepository;
import com.example.cinema_3.Repositories.MovieRepository;
import com.example.cinema_3.Repositories.MovieTypeRepository;
import com.example.cinema_3.domain.Actor;
import com.example.cinema_3.domain.Category;
import com.example.cinema_3.domain.Movie;
import com.example.cinema_3.domain.MovieType;
import com.example.cinema_3.dto.ActorDTO;
import com.example.cinema_3.dto.CategoryDTO;
import com.example.cinema_3.dto.MovieDTO;
import com.example.cinema_3.dto.MovieTypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class MovieServices {


    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieTypeRepository movieTypeRepository;


    @Autowired
    private  ModelMapper mapper;

    public Movie save(MovieDTO movieDTO) {

        Movie movie = new Movie();

        movie.setMovieName(movieDTO.getMovieName());
        movie.setMovieShortDescription(movieDTO.getMovieShortDescription());
        movie.setMovieDescription(movieDTO.getMovieDescription());
        movie.setMovieLength(movieDTO.getMovieLength());
        movie.setMovieImageUrl(movieDTO.getMovieImageUrl());
        movie.setMovieAgeAllowed(movieDTO.getMovieAgeAllowed());
        movie.setMovieTrailerUrl(movieDTO.getMovieTrailerUrl());

        // Set Category
        Set<Category> categories = new HashSet<>();

        Set<CategoryDTO> categoryDTOSet = movieDTO.getMovieCategories();
        for (CategoryDTO categoryDTO : categoryDTOSet) {
            String name = categoryDTO.getCategoryName();


            Category category = categoryRepository.findCategoryByCategoryName(name);


            categories.add(category);

        }
        movie.setCategories(categories);

        // Set Actors
        Set<Actor> actors = new HashSet<>();

        Set<ActorDTO> actorDTOSet = movieDTO.getMovieActories();

        for (ActorDTO actorDTO : actorDTOSet) {
            String name = actorDTO.getActorName();

            Actor actor = actorRepository.findActorsByActorName(name);
            actors.add(actor);
        }
        movie.setActors(actors);


        //Set types
        Set<MovieType> movieTypes = new HashSet<>();

        Set<MovieTypeDTO> movieTypeDTOSet   = movieDTO.getMovieTypes();

        for (MovieTypeDTO movieTypeDTO : movieTypeDTOSet) {
            String name = movieTypeDTO.getMovieType();

            MovieType movieType = movieTypeRepository.findMovieTypeByTypeName(name);

            movieTypes.add(movieType);
        }
        movie.setTypes(movieTypes);



        movieRepository.save(movie);

        return movie;


    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id){
        return movieRepository.findById(id);
    }

    public void updateMovieById(Long movieID ,MovieDTO movieDTO) {
        // find movie by Id
        Optional<Movie> movieOpt = movieRepository.findMovieByMovieId(movieID);

        Movie movie = movieOpt.get();

        Set<Category> categories = new HashSet<>();
        // set with mapper
        for (CategoryDTO movieCategory : movieDTO.getMovieCategories()) {
            Category category = categoryRepository.findCategoryByCategoryName(movieCategory.getCategoryName());
            categories.add(category);
        }

        Set<Actor> actors = new HashSet<>();
        for (ActorDTO movieActory : movieDTO.getMovieActories()) {
            Actor actor = actorRepository.findActorsByActorName(movieActory.getActorName());
            actors.add(actor);
        }

        movie = mapper.map(movieDTO, Movie.class);
        movie.setCategories(categories);
        movie.setActors(actors);
        movie.setMovieId(movieID);
        System.out.println("haha");


        movieRepository.save(movie);
    }

    public void deleteById(Long movieID) {


        // clear the forein keys then update it
        Optional<Movie> movie = movieRepository.findMovieByMovieId(movieID);
        Movie movieObject = movie.get();
        movieObject.getActors().clear();
        movieObject.getCategories().clear();
        movieObject.getTypes().clear();
        movieRepository.save(movieObject);

        // delete it

        movieRepository.deleteById(movieID);
    }
}

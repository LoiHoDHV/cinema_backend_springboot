package com.example.cinema_3.dto;

import java.util.Set;

public class MovieDTO {

    private String movieName;
    private Set<CategoryDTO> movieCategories;
    private Set<ActorDTO> movieActories;

    private Set<MovieTypeDTO> movieTypes;
    private String movieShortDescription;
    private String movieDescription;
    private Integer movieLength;
    private String movieImageUrl;
    private Integer movieAgeAllowed;
    private String movieTrailerUrl;


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Set<CategoryDTO> getMovieCategories() {
        return movieCategories;
    }

    public void setMovieCategories(Set<CategoryDTO> movieCategories) {
        this.movieCategories = movieCategories;
    }

    public Set<ActorDTO> getMovieActories() {
        return movieActories;
    }

    public void setMovieActories(Set<ActorDTO> movieActories) {
        this.movieActories = movieActories;
    }

    public String getMovieShortDescription() {
        return movieShortDescription;
    }

    public void setMovieShortDescription(String movieShortDescription) {
        this.movieShortDescription = movieShortDescription;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public Integer getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(Integer movieLength) {
        this.movieLength = movieLength;
    }

    public String getMovieImageUrl() {
        return movieImageUrl;
    }

    public void setMovieImageUrl(String movieImageUrl) {
        this.movieImageUrl = movieImageUrl;
    }

    public Integer getMovieAgeAllowed() {
        return movieAgeAllowed;
    }

    public void setMovieAgeAllowed(Integer movieAgeAllowed) {
        this.movieAgeAllowed = movieAgeAllowed;
    }

    public String getMovieTrailerUrl() {
        return movieTrailerUrl;
    }

    public void setMovieTrailerUrl(String movieTrailerUrl) {
        this.movieTrailerUrl = movieTrailerUrl;
    }

    public Set<MovieTypeDTO> getMovieTypes() {
        return movieTypes;
    }

    public void setMovieTypes(Set<MovieTypeDTO> movieTypes) {
        this.movieTypes = movieTypes;
    }
}

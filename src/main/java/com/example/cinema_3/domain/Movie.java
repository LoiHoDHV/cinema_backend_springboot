package com.example.cinema_3.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name= "tbl_movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(name = "movie_name", unique = true)
    private String movieName;

    @Column (name = "movie_image_url")
    private String movieImageUrl;


//    Category JOIN
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_movie_category",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    @JsonManagedReference
    private Set<Category> categories;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_movie_type",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "type_id")}
    )
    @JsonManagedReference
    private Set<MovieType> movieTypes;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_movie_actor",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    @JsonManagedReference
    private Set<Actor> actors;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ShowTime> showTimes;



    @Column(name= "moive_short_description", length = 65535)
    private String movieShortDescription;

    @Column(name = "movie_description", length = 65535)
    private String movieDescription;
    @Column(name="movie_lenght")
    private Integer movieLength;
    @Column(name ="movie_age_allow", columnDefinition = " int default 15")
    private Integer movieAgeAllowed;
    @Column(name = "movie_trailer_url")
    private String movieTrailerUrl;
    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImageUrl() {
        return movieImageUrl;
    }

    public void setMovieImageUrl(String movieImageUrl) {
        this.movieImageUrl = movieImageUrl;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    // Another Link
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<MovieType> getTypes() {
        return movieTypes;
    }

    public void setTypes(Set<MovieType> movieTypes) {
        this.movieTypes = movieTypes;
    }


    public Set<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(Set<ShowTime> showTimes) {
        this.showTimes = showTimes;
    }

    public Set<Actor> getActors() {
        return actors;
    }
    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }



}

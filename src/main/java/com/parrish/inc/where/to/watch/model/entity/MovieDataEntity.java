package com.parrish.inc.where.to.watch.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "movie_data")
public class MovieDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "movieName")
    private String movieName;

    @Column(name = "movieDate")
    private Integer movieDate;

    @Column(name = "movieStreamingLocations")
    private String[] movieStreamingLocations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Integer getMovieDate() {
        return movieDate;
    }

    public void setMovieDate(Integer movieDate) {
        this.movieDate = movieDate;
    }

    public String[] getMovieStreamingLocations() {
        return movieStreamingLocations;
    }

    public void setMovieStreamingLocations(String[] movieStreamingLocations) {
        this.movieStreamingLocations = movieStreamingLocations;
    }
}
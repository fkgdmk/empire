package com.outofbounds.empire.Statistics.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.outofbounds.empire.Movies.Models.Movie;
import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistic {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne()
    @JsonManagedReference
    @JoinColumn(name = "movie.id")
    private Movie movie;

    @Column(name = "totalReservations")
    private int totalReservations;

    public Statistic(int totalReservations, Movie movie) {
        this.totalReservations = totalReservations;
        this.movie = movie;
    }

    //NoArg Constructor
    public Statistic() {}

    public int getTotalReservations() {
        return totalReservations;
    }

    public void setTotalReservations(int totalReservations) {
        this.totalReservations = totalReservations;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
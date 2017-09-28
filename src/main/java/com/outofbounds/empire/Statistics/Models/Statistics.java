package com.outofbounds.empire.Statistics.Models;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "movie_id")
    private int movieID;

    @Column(name = "totalReservations")
    private int totalReservations;


    public Statistics(int movieID, int totalSeat) {
        this.movieID = movieID;
        this.totalReservations = totalSeat;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getTotalReservations() {
        return totalReservations;
    }

    public void setTotalReservations(int totalReservations) {
        this.totalReservations = totalReservations;
    }

}
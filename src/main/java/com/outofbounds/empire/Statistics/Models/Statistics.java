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

    @Column(name = "totalSeat", nullable = true)
    private int totalSeat;

    @Column(name = "seatsPrScreening")
    private int seatPrScreening;

    public Statistics(int movieID, int totalSeat, int seatPrScreening) {
        this.movieID = movieID;
        this.totalSeat = totalSeat;
        this.seatPrScreening = seatPrScreening;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public int getSeatPrScreening() {
        return seatPrScreening;
    }

    public void setSeatPrScreening(int seatPrScreening) {
        this.seatPrScreening = seatPrScreening;
    }
}
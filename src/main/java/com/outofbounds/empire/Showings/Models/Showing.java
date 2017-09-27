package com.outofbounds.empire.Showings.Models;

import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Reservation.Models.Reservation;
import com.outofbounds.empire.Showrooms.Models.Showroom;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * Created by Anders on 26-Sep-17.
 */
@Entity
@Table(name = "showings")
public class Showing {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "movie.id", nullable = false)
    private Movie movie;

    @ManyToOne()
    @JoinColumn(name = "showroom.id", nullable = false)
    private Showroom showroom;

    @OneToMany(mappedBy = "showing")
    private List<Reservation> reservation;

    @Column(name = "datetime")
    private Date datetime;

    public Showing(Movie movie, Showroom showroom, Date datetime) {
        this.movie = movie;
        this.showroom = showroom;
        this.datetime = datetime;
    }

    public Showing() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Showroom getShowroom() {
        return showroom;
    }

    public void setShowroom(Showroom showroom) {
        this.showroom = showroom;
    }
}

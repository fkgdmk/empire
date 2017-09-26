package com.outofbounds.empire.Showings.Model;

import com.outofbounds.empire.Movies.Models.Movie;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Anders on 26-Sep-17.
 */
@Entity
@Table(name = "showings")
public class Showing {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    private Movie movie;

    @Column(name = "title")
    private String movieTitle;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "ageLimit")
    private int ageLimit;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private float price;

    @Column(name = "datetime")
    private Date datetime;

    @Column(name = "showroom")
    private int showroom;

    public Showing(Movie movie, int showroom, Date datetime) {
        this.movie = movie;
        this.showroom = showroom;
        this.datetime = datetime;

        this.movieTitle = movie.getTitle();
        this.description = movie.getDescription();
        this.ageLimit = movie.getAgeLimit();
        this.category = movie.getCategory();
        this.price = movie.getPrice();
    }

    public Showing(){}

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getShowroom() {
        return showroom;
    }

    public void setShowroom(int showroom) {
        this.showroom = showroom;
    }
}

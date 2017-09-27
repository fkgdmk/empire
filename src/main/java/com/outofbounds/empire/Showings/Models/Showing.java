package com.outofbounds.empire.Showings.Models;

import com.outofbounds.empire.Movies.Models.Movie;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Anders on 26-Sep-17.
 */
@Entity
@Table(name = "showings")
public class Showing
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "movie.id", nullable = false)
    private Movie movie;

    @Column(name = "datetime")
    private Date datetime;

    @Column(name = "showroom")
    private int showroom;

    public Showing(Movie movie, int showroom, Date datetime)
    {
        this.movie = movie;
        this.showroom = showroom;
        this.datetime = datetime;
    }

    public Showing() {}

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Movie getMovie() {return movie;}

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }

    public Date getDatetime() {
        return datetime;}

    public void setDatetime(Date datetime)
    {
        this.datetime = datetime;
    }

    public int getShowroom()
    {
        return showroom;
    }

    public void setShowroom(int showroom)
    {
        this.showroom = showroom;
    }
}

package com.outofbounds.empire.Showings.Models;

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
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "movie_title")
    private String movietitle;

    @Column(name = "datetime")
    private Date datetime;

    @Column(name = "showroom")
    private int showroom;

    public Showing(String movietitle, int showroom, Date datetime)
    {
        this.movietitle = movietitle;
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

    public String getMovietitle()
    {
        return movietitle;
    }

    public void setMovietitle(String movietitle)
    {
        this.movietitle = movietitle;
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

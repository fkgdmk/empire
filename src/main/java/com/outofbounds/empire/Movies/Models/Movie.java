package com.outofbounds.empire.Movies.Models;

import com.outofbounds.empire.Showings.Models.Showing;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "descriptions", nullable = true)
    private String description;

    @OneToMany(mappedBy = "movie")
    private List<Showing> showings;

    @Column(name = "age_limit")
    private int ageLimit;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private float price;

    public Movie(int id, String title, String description, int ageLimit, String category, float price, List<Showing> showings) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.ageLimit = ageLimit;
        this.category = category;
        this.price = price;
        this.showings = showings;
    }

    // Non arg
    public Movie() {}

    public List<Showing> getShowings()
    {
        return showings;
    }

    public void setShowings(List<Showing> showings)
    {
        this.showings = showings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

package com.outofbounds.empire.Movies.Models;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "descriptions", nullable = true)
    private String description;

    @Column(name = "age_limit")
    private int ageLimit;

    @Column(name = "category")
    private String category;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;

    @Column(name = "price")
    private int price;

    public Movie(String title, String description, int ageLimit, String category, float price, String imageUrl) {
        this.title = title;
        this.description = description;
        this.ageLimit = ageLimit;
        this.category = category;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Non arg
    public Movie() {}

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

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

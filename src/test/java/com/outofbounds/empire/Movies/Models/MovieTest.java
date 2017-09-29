package com.outofbounds.empire.Movies.Models;

import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import com.outofbounds.empire.Showings.Models.Showing;
import com.outofbounds.empire.Showings.Repositories.ShowingRepository;
import com.outofbounds.empire.Showrooms.Models.Showroom;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import static org.junit.Assert.*;
import java.util.Date;

public class MovieTest {

    public MovieTest() throws Exception {
    }

    @Autowired
    ShowingRepository showingRepository;

    Movie mov = new Movie("title","description",13,"category",140,"imageURL");
    Showroom showroom = new Showroom("show1",10,20);
    java.util.Date datetime = new java.util.Date();
    Showing show = new Showing(mov,showroom,datetime);
    List<Showing> list = showingRepository.findAll();



    @Test
    public void getShowings() throws Exception {
    }

    @Test
    public void setShowings() throws Exception {
    }

    @Test
    public void getId() throws Exception {
    }

    @Test
    public void setId() throws Exception {
    }

    @Test
    public void getTitle() throws Exception {
    }

    @Test
    public void setTitle() throws Exception {
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void setDescription() throws Exception {
    }

    @Test
    public void getAgeLimit() throws Exception {
    }

    @Test
    public void setAgeLimit() throws Exception {
    }

    @Test
    public void getCategory() throws Exception {
    }

    @Test
    public void setCategory() throws Exception {
    }

    @Test
    public void getPrice() throws Exception
    {
    }

    @Test
    public void setPrice() throws Exception
    {
    }

    @Test
    public void getImageUrl() throws Exception
    {
    }

    @Test
    public void setImageUrl() throws Exception
    {
    }

}
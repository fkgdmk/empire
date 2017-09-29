package com.outofbounds.empire.Movies.Models;

import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {
    public MovieTest() throws Exception {
    }
    Movie mov = new Movie("title","description",13,"category",140,"imageURL");

    @Test
    public void getId() throws Exception {
        assertEquals(0, mov.getId());
        mov.setId(1);
        assertEquals(1, mov.getId());
    }

    @Test
    public void setId() throws Exception {
        mov.setId(1888);
        assertEquals(1888, mov.getId());
    }

    @Test
    public void getTitle() throws Exception {
        assertEquals("title", mov.getTitle());
    }

    @Test
    public void setTitle() throws Exception {
        assertEquals("title", mov.getTitle());
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals("description", mov.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        mov.setDescription("description");
        assertEquals("description", mov.getDescription());
    }

    @Test
    public void getAgeLimit() throws Exception {
        assertEquals(13, mov.getAgeLimit());
    }

    @Test
    public void setAgeLimit() throws Exception {
        mov.setAgeLimit(99);
        assertEquals(99, mov.getAgeLimit());
    }

    @Test
    public void getCategory() throws Exception {
        assertEquals("category", mov.getCategory());
    }

    @Test
    public void setCategory() throws Exception {
        mov.setCategory("test");
        assertEquals("test", mov.getCategory());
    }

    @Test
    public void getPrice() throws Exception{
        assertEquals(140, mov.getPrice());
    }

    @Test
    public void setPrice() throws Exception{
        mov.setPrice(999);
        assertEquals(999, mov.getPrice());
    }

    @Test
    public void getImageUrl() throws Exception {
        assertEquals("imageURL", mov.getImageUrl());
    }

    @Test
    public void setImageUrl() throws Exception {
        mov.setImageUrl("test#");
        assertEquals("test", mov.getImageUrl());
    }
}
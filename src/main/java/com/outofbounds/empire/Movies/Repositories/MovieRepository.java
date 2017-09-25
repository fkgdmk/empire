package com.outofbounds.empire.Movies.Repositories;

import com.outofbounds.empire.Movies.Models.Movie;

import java.util.ArrayList;

public class MovieRepository {
    private ArrayList movies = new ArrayList();

    public MovieRepository ()
    {
        Movie movieOne = new Movie(
                1,
                "Terminator the end of Java",
                "A movie about Arnold C and his path to Jav",
                10,
                "Action",
                99
        );

        this.movies.add(movieOne);

        Movie movieTwo = new Movie(
                2,
                "2017 Java is comming",
                "A movie about Java and the way it changed the world",
                5,
                "Documentary",
                10
        );

        this.movies.add(movieTwo);

        Movie movieThree = new Movie(
                3,
                "The revenge of the bus",
                "A movie about a bus that are late",
                12,
                "Horror",
                89
        );

        this.movies.add(movieThree);
    }

    public ArrayList getMovies() {
        return movies;
    }
}

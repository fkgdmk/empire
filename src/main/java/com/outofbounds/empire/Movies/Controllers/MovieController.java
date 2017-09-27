package com.outofbounds.empire.Movies.Controllers;

import com.outofbounds.empire.MovieDBApi.Models.MovieDBApi;
import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
class MovieController {

    @Autowired
    public MovieRepository movieRepository;

    /**
     * Basic route for movies
     * @return Movie
     */
    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    public @ResponseBody
    List<Movie> movies() throws Exception {
        MovieDBApi movieDB = new MovieDBApi();
        movieDB.MovietoDB();
        return movieRepository.findAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies/{id}")
    public @ResponseBody
    Movie movie(@PathVariable int id)
    {
        return movieRepository.findById(id);


    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies/generate/random")
    public @ResponseBody
    List<Movie> createMovie() throws Exception {
        MovieDBApi movieDB = new MovieDBApi();
        ArrayList<Movie> movies = movieDB.MovietoDB();
        for (int i = 0; i < 10 ; i++) {

            Movie movie = new Movie(

                    movies.get(i).getTitle(),
                    movies.get(i).getDescription(),
                    18,
                    movies.get(i).getCategory(),
                    100,
                    movies.get(i).getImageUrl()

            );
            movieRepository.save(movie);
        }

        return movieRepository.findAll();
    }
}
package com.outofbounds.empire.Movies.Controllers;

import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
    List<Movie> movies() {
        return movieRepository.findAll();
    }
}
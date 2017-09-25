package com.outofbounds.empire.Movies.Controllers;

import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MovieController {

    /**
     * Basic route for movies
     * @return Movie
     */
    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    public @ResponseBody
    MovieRepository Movie() {
        return new MovieRepository();
    }
}
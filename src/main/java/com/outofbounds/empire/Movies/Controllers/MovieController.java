package com.outofbounds.empire.Movies.Controllers;

import com.outofbounds.empire.Movies.Models.Movie;
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
    Movie Movie() {
        return new Movie(1,"test");
    }
}
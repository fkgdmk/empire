package com.outofbounds.empire.Movies.Controllers;

import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public @ResponseBody List<Movie> movies() {
        return movieRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/movies/{id}")
    public @ResponseBody
    Movie updateMovie(@PathVariable int id,
                      @RequestParam (required = false) String title,
                      @RequestParam (required = false) String description,
                      @RequestParam (required = false) String category,
                      @RequestParam (required = false) Integer ageLimit,
                      @RequestParam (required = false) Integer price)
    {
        Movie movie = movieRepository.findById(id);

        try {
            movie.setTitle(title);
            movie.setDescription(description);
            movie.setCategory(category);
            movie.setAgeLimit(ageLimit);
            movie.setPrice(price);
        } catch (NullPointerException e) {

        }
        movieRepository.save(movie);
        return movie;
    }


//    @RequestMapping(method = RequestMethod.PUT, value = "/movies/{id}")
//    public @ResponseBody
//    Movie updateTitle(@PathVariable int id, String newTitle, String newDescription, String category, float price)
//    {
//
//        Movie movie = movieRepository.findById(1);
//
//        movie.setTitle("Lol filmen");
//        movie.setDescription("Fed desc");
//        movie.setAgeLimit(19);
//        movie.setCategory("romance");
//        movie.setPrice(90.2f);
//
//        movieRepository.save(movie);
//
//        return movie;
//    }
}
package com.outofbounds.empire.Movies.Controllers;

import com.outofbounds.empire.MovieDBApi.Models.MovieDBApi;
import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.required;

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
        return movieRepository.findAll();
    }

    //@CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.DELETE, value = "/movies/{id}")
    public @ResponseBody
    boolean deleteMovie(
            @PathVariable int id
    )
    {
        Movie movie = movieRepository.findById(id);

        if (movie == null){
            return false;
        }
        movieRepository.delete(movie);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/movies/{id}")
    public @ResponseBody
    Movie updateMovie(
            @PathVariable int id,
            @RequestParam (required = false) String title,
            @RequestParam (required = false) String description,
            @RequestParam (required = false) Integer ageLimit,
            @RequestParam (required = false) String category,
            @RequestParam (required = false) Integer price,
            @RequestParam (required = false) String url
    ){
        Movie movie = movieRepository.findById(id);
        try {
            movie.setTitle(title);
            movie.setDescription(description);
            movie.setAgeLimit(ageLimit);
            movie.setCategory(category);
            movie.setPrice(price);
            movie.setImageUrl(url);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        movieRepository.save(movie);
        return movie;
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/movies/{id}")
    public @ResponseBody
    Movie movie(@PathVariable int id) {
        return movieRepository.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/movies/generate/random")
    public @ResponseBody
    List<Movie> createMovie() throws Exception {
        MovieDBApi movieDB = new MovieDBApi();
        ArrayList<Movie> movies = movieDB.MovietoDB();
        for (int i = 0; i < movies.size() ; i++) {
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
package com.outofbounds.empire.Showings.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import com.outofbounds.empire.Showings.Models.Showing;
import com.outofbounds.empire.Showings.Repositories.ShowingRepository;
import com.outofbounds.empire.Showrooms.Models.Showroom;
import com.outofbounds.empire.Showrooms.Repositories.ShowroomRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Anders on 26-Sep-17.
 */
@RestController
public class ShowingController {
    @Autowired
    public ShowingRepository showingRepository;

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    public ShowroomRepository showroomRepository;

    /**
     * Basic route for showings
     * @return Showing
     */

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/showings")
    public @ResponseBody
    List<Showing> showings() {
        return showingRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.POST, value = "/showings")
    public @ResponseBody
    Showing addShowing(
            @RequestParam (required = true) int movie_id,
            @RequestParam (required = true) int showroom_id
    )
    {
        Showing showing = new Showing(
                movieRepository.findById(movie_id),
                showroomRepository.findById(showroom_id),
                new Date()
        );
        showingRepository.save(showing);
        return showing;
    }
}
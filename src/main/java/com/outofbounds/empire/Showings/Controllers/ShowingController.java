package com.outofbounds.empire.Showings.Controllers;

import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import com.outofbounds.empire.Showings.Models.Showing;
import com.outofbounds.empire.Showings.Repositories.ShowingRepository;
import com.outofbounds.empire.Showrooms.Repositories.ShowroomRepository;
import com.pusher.rest.Pusher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
public class ShowingController {
    @Autowired
    public ShowingRepository showingRepository;

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    public ShowroomRepository showroomRepository;

    @Autowired
    private Environment env;

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
    @RequestMapping(method = RequestMethod.GET, value = "/showings/{id}")
    public @ResponseBody
    Showing showing(@PathVariable int id) {
        return showingRepository.findById(id);
    }

    @CrossOrigin(origins = {"http://localhost:8000"})
    @RequestMapping(method = RequestMethod.PUT, value = "/showings/{id}/viewing")
    public @ResponseBody
    Boolean pushToWebsocket(@PathVariable int id, @RequestBody String seatNumber)
    {
        Pusher pusher = new Pusher(
                env.getProperty("pusher.appId"),
                env.getProperty("pusher.key"),
                env.getProperty("pusher.secret")
        );

        pusher.setCluster("eu");
        pusher.setEncrypted(true);

        pusher.trigger(
                "showing_reservations",
                "" + id,
                seatNumber
        );

        return true;
    }

    //@CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.POST, value = "/showings")
    public @ResponseBody
    Showing addShowing(
            @RequestParam (required = true) int movie_id,
            @RequestParam (required = true) int showroom_id,
            @RequestParam (required = true) String date
    )
    {
        Date datetime = null;
        DateFormat df = new SimpleDateFormat("MM dd HH mm yyyy", Locale.ENGLISH);
        try {
            datetime = df.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Showing showing = new Showing(
                movieRepository.findById(movie_id),
                showroomRepository.findById(showroom_id),
                datetime
        );
        showingRepository.save(showing);
        return showing;
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.DELETE, value = "/showings/{id}")
    public @ResponseBody
    boolean deleteShowing(@PathVariable int id) {
        Showing showing = showingRepository.findById(id);
        if (showing == null) {
            return false;
        }
        showingRepository.delete(showing);
        return true;
    }
}
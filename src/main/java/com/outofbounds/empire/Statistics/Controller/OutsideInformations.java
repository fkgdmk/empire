package com.outofbounds.empire.Statistics.Controller;

import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Showings.Models.Showing;
import com.outofbounds.empire.Reservation.Models.Reservation;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

public class OutsideInformations {

    public @ResponseBody
    List<Movie> movies() {
        return movies();
    }
    public @ResponseBody
    List<Showing> showings() {
        return showings();
    }

    public @ResponseBody
    List<Reservation> reservations() {
        return reservations();
    }
}
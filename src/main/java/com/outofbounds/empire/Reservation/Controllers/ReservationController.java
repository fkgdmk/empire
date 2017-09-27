package com.outofbounds.empire.Reservation.Controllers;

import com.outofbounds.empire.Reservation.Models.Reservation;
import com.outofbounds.empire.Reservation.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class ReservationController {
    @Autowired
    public ReservationRepository reservationRepository;

    /**
     * Basic route for movies
     * @return Movie
     */
    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/reservations")
    public @ResponseBody
    List<Reservation> reservations() {
        return reservationRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/movies/{id}")
    public @ResponseBody
    Reservation reservation(@PathVariable int id) {
        return reservationRepository.findById(id);
    }


}
package com.outofbounds.empire.Reservation.Controllers;

import com.outofbounds.empire.Reservation.Models.Reservation;
import com.outofbounds.empire.Reservation.Repositories.ReservationRepository;
import com.outofbounds.empire.Showings.Repositories.ShowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
class ReservationController {
    @Autowired
    public ReservationRepository reservationRepository;
    @Autowired
    public ShowingRepository showingRepository;

    /**
     * Basic route for movies
     * @return Movie
     */
    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/reservation")
    public @ResponseBody
    List<Reservation> reservations() {
        return reservationRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/reservations/{id}")
    public @ResponseBody
    Reservation reservation(@PathVariable int id) {
        return reservationRepository.findById(id);
   }

    //@CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.POST, value = "/reservations")
    public @ResponseBody
    Reservation addReservation(
            @RequestParam (required = true) int seats,
            @RequestParam (required = true) String phoneNumber,
            @RequestParam (required = true) int showroomid ) {

        Reservation reservation = new Reservation(showingRepository.findById(showroomid),seats,phoneNumber);
        reservationRepository.save(reservation);
        return reservation;
    }
  
    //@CrossOrigin(origins = {"http://localhost:8000"})
    @RequestMapping(method = RequestMethod.DELETE, value = "/reservations/{id}")
    public @ResponseBody
    boolean deleteReservation(@PathVariable int id){
        Reservation reservation =  reservationRepository.findById(id);
        if(reservation == null){
            return false;
        }
        reservationRepository.delete(reservation);
        return true;
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/reservations/test/{showingId}")
    public @ResponseBody
    List<Reservation> getReservationById(@PathVariable int showingId) {

        List<Reservation> list = reservationRepository.findAll();

        for(Iterator<Reservation> r = list.iterator(); r.hasNext(); ) {
            Reservation reservation = r.next();
            if(!(reservation.getShowing().getId() == showingId)){
                r.remove();
            }
        }
        return list;
    }
}
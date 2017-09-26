package com.outofbounds.empire.Seats.Controllers;

import com.outofbounds.empire.Seats.Models.Seat;
import com.outofbounds.empire.Showrooms.Repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeatController
{

    @Autowired
    public SeatRepository seatRepository;

    /**
     * Basic route for seats
     * @return seat
     */
    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/seat")
    public @ResponseBody
    List<Seat> seat() {
        return seatRepository.findAll();
    }
}

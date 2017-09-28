package com.outofbounds.empire.Showrooms.Controllers;

import com.outofbounds.empire.Showrooms.Models.Showroom;
import com.outofbounds.empire.Showrooms.Repositories.ShowroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowroomController {
    @Autowired
    public ShowroomRepository showroomRepository;

    /**
     * Basic route for showrooms
     * @return reservations
     */
    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/showrooms")
    public @ResponseBody
    List<Showroom> showroom() {
        return showroomRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/showrooms/generate")
    public @ResponseBody
    List<Showroom> createShowrooms() {
        Showroom showroom1 = new Showroom("Room One", 12, 20);
        Showroom showroom2 = new Showroom("Room Two", 20, 20);
        showroomRepository.save(showroom1);
        showroomRepository.save(showroom2);
        return showroomRepository.findAll();
    }
}

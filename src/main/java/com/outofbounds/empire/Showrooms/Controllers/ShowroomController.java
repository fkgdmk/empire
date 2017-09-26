package com.outofbounds.empire.Showrooms.Controllers;

import com.outofbounds.empire.Showrooms.Models.Showroom;
import com.outofbounds.empire.Showrooms.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShowroomController
{

    @Autowired
    public ShowroomRepository showroomRepository;

    /**
     * Basic route for showrooms
     * @return showroom
     */
    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/showroom")
    public @ResponseBody
    List<Showroom> showroom() {
        return showroomRepository.findAll();
    }
}

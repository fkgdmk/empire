package com.outofbounds.empire.Showings.Controllers;

import com.outofbounds.empire.Showings.Models.Showing;
import com.outofbounds.empire.Showings.Repositories.ShowingRepository;
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

    /**
     * Basic route for showings
     * @return Showing
     */

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping(method = RequestMethod.GET, value = "/showings")
    public @ResponseBody
    List<Showing> showings() {
        return showingRepository.findAll();
    }

//    @CrossOrigin(origins = "http://localhost:8080")
//    @RequestMapping(method = RequestMethod.POST, value = "/showings")
//    public @ResponseBody
//    Showing showingsAdd() {
//        return showingRepository.save(new Showing("R 1", new Date()));
//    }


}
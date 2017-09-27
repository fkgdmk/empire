package com.outofbounds.empire.Costumers.Controllers;

import com.outofbounds.empire.Costumers.Repostitories.RepositorieCostumer;
import com.outofbounds.empire.Costumers.Models.CostumerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Costumerscontroller {


    @Autowired
    public RepositorieCostumer repositorieCostumer;

    /**
     * Basic route for movies
     *
     * @return Movie
     */
    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/movies")
    public @ResponseBody
    List<CostumerModel> movies() {
        return repositorieCostumer.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, value = "")
    public @ResponseBody
    CostumerModel costumerModel(@PathVariable int id) {
        return repositorieCostumer.findById(id);
    }

    public @ResponseBody
    CostumerModel costumerModel(@PathVariable String phoneNumber) {return repositorieCostumer.findByPhoneNumber(phoneNumber);}

    /*@RequestMapping(method = RequestMethod.GET, value = "/movies/generate/random")*/
}




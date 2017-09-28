package com.outofbounds.empire.Statistics.Controller;

import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import com.outofbounds.empire.Reservation.Models.Reservation;
import com.outofbounds.empire.Showings.Models.Showing;
import com.outofbounds.empire.Showings.Repositories.ShowingRepository;
import com.outofbounds.empire.Showrooms.Models.Showroom;
import com.outofbounds.empire.Showrooms.Repositories.ShowroomRepository;
import com.outofbounds.empire.Statistics.Models.Statistics;
import com.outofbounds.empire.Statistics.Repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class StatisticsController {

    @Autowired
    public StatisticsRepository statisticsRepositories;

    @Autowired
    public ShowingRepository showingRepository;

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    public ShowroomRepository showroomRepository;
    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/Statistics")
    public @ResponseBody
    List<Statistics> statisticsModels() {

        return statisticsRepositories.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.PUT, value = "/Statistics")
    public @ResponseBody
    Statistics updateStatisticModel(
            @PathVariable int id,
            @RequestParam(required = false) int title,
            @RequestParam(required = false) int description,
            @RequestParam(required = false) int category
            ) {
        Statistics statistics = statisticsRepositories.findById(id);

        try {

        } catch (NullPointerException e) {
        }
        statisticsRepositories.save(statistics);
        return statistics;
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/Statistics{id}")
    public @ResponseBody
    Statistics statisticsModel(@PathVariable int id) {
        return statisticsRepositories.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.PUT, value = "/Statistics")
    public @ResponseBody
    List<Statistics> Statistics()
    {
        OutsideInformations outsideInformations = new OutsideInformations();
        List<Movie> movieList                   = outsideInformations.movies();
        List<Showing> showingsList              = outsideInformations.showings();
        List<Reservation> reservations          = outsideInformations.reservations();
        int timeRunThroug = movieList.size();

        for (int i = 0; i < timeRunThroug; i++) {
            int tempMovie;
            tempMovie = movieList.get(i).getId();
            ArrayList<Integer> tempShowingIDs   = new ArrayList<Integer>();
            int showListSize=showingsList.size();

            for (int j = 0; j < showListSize; j++) {
                if (showingsList.get(i).getMovie().getId()==tempMovie){
                    tempShowingIDs.add(showingsList.get(i).getMovie().getId());
                }
            }
            showListSize=tempShowingIDs.size();
            int amountOfSoldSeats=0;
            for (int j = 0; j < showListSize; j++) {
                int tempShowingID = tempShowingIDs.get(i);
                if(tempShowingID == reservations.get(i).getShowing().getId()){
                    amountOfSoldSeats++;
                }
            }
            int seatsPrScreening=amountOfSoldSeats/showListSize;

            Statistics statistics = new Statistics(tempMovie, amountOfSoldSeats, seatsPrScreening);
            statisticsRepositories.save(statistics);
        }
        return statisticsRepositories.findAll();
    }
}
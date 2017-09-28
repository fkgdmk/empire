package com.outofbounds.empire.Statistics.Controller;

import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import com.outofbounds.empire.Reservation.Models.Reservation;
import com.outofbounds.empire.Reservation.Repositories.ReservationRepository;
import com.outofbounds.empire.Showings.Models.Showing;
import com.outofbounds.empire.Showings.Repositories.ShowingRepository;
import com.outofbounds.empire.Showrooms.Models.Showroom;
import com.outofbounds.empire.Showrooms.Repositories.ShowroomRepository;
import com.outofbounds.empire.Statistics.Models.Statistics;
import com.outofbounds.empire.Statistics.Repositories.StatisticsRepository;
import com.sun.org.glassfish.external.statistics.Statistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class StatisticsController {

    @Autowired
    public StatisticsRepository statisticsRepositories;

    @Autowired
    public ShowingRepository showingRepository;

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    public ShowroomRepository showroomRepository;

    @Autowired
    public ReservationRepository reservationRepository;

    /*
    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/statistics/statisticsModels")
    public @ResponseBody
    List<Statistics> statisticsModels() {
        return statisticsRepositories.findAll();
    }

    //@CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.PUT, value = "/statistics/updateStatisticModel")
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
    @RequestMapping(method = RequestMethod.GET, value = "/statistics{id}")
    public @ResponseBody
    Statistics statisticsModel(@PathVariable int id) {
        return statisticsRepositories.findById(id);
    }

    //@CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.PUT, value = "/statistics")
    public @ResponseBody
    List<Statistics> statistics()
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

            Statistics statistics = new Statistics(tempMovie, amountOfSoldSeats);
            statisticsRepositories.save(statistics);
        }
        return statisticsRepositories.findAll();
    }
    */

    //@CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/statistics/test/{movieId}")
    public @ResponseBody
    List<Reservation> getReservationsWithMovieID(@PathVariable int movieId) {

        List<Showing> list = showingRepository.findAll();
        List<Reservation> totalReservations = reservationRepository.findAll();
        List<Reservation> reservations = new ArrayList<>();

        for(Showing showing: list) {
            if((showing.getMovie().getId() == movieId)){
                //Found a showing, that showed X movie
                int showingID = showing.getId();
                //Now find how many reservations very made at this showing
                for (Reservation reservation: totalReservations) {
                    if (reservation.getShowing().getId() == showingID) {
                        reservations.add(reservation);
                    } //else the reservation is not in a showing, that showed the movie
                }
            }
        }

        Statistics statistics = new Statistics(movieId, reservations.size());
        statisticsRepositories.save(statistics);

        return reservations;
    }
}
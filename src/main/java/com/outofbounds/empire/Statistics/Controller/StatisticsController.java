package com.outofbounds.empire.Statistics.Controller;

import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Movies.Repositories.MovieRepository;
import com.outofbounds.empire.Reservation.Models.Reservation;
import com.outofbounds.empire.Reservation.Repositories.ReservationRepository;
import com.outofbounds.empire.Showings.Models.Showing;
import com.outofbounds.empire.Showings.Repositories.ShowingRepository;
import com.outofbounds.empire.Showrooms.Repositories.ShowroomRepository;
import com.outofbounds.empire.Statistics.Models.Statistic;
import com.outofbounds.empire.Statistics.Repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StatisticsController {

    @Autowired
    public StatisticsRepository statisticsRepository;

    @Autowired
    public ShowingRepository showingRepository;

    @Autowired
    public MovieRepository movieRepository;

    @Autowired
    public ShowroomRepository showroomRepository;

    @Autowired
    public ReservationRepository reservationRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/statistics/{movieId}")
    public @ResponseBody
    Statistic getStatisticsByMovieID(@PathVariable int movieId) {

        List<Showing> list = showingRepository.findAll();
        List<Reservation> totalReservations = reservationRepository.findAll();
        int countOfReservations = 0;

        for(Showing showing: list) {
            if((showing.getMovie().getId() == movieId)){
                for (Reservation reservation: totalReservations) {
                    if (reservation.getShowing().getId() == showing.getId()) {
                        countOfReservations++;
                    }
                }
            }
        }
        Statistic statistic = new Statistic(countOfReservations, movieRepository.findById(movieId));
        statisticsRepository.save(statistic);
        return statistic;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/statistics/generate")
    public @ResponseBody
    List<Statistic> createStatistics() {
        List<Statistic> statistics = new ArrayList<>();
        List<Showing> list = showingRepository.findAll();
        List<Reservation> totalReservations = reservationRepository.findAll();

        for (Movie movie: movieRepository.findAll()) {
            int countOfReservations = 0;

            for(Showing showing: list) {
                if((showing.getMovie().getId() == movie.getId())){
                    for (Reservation reservation: totalReservations) {
                        if (reservation.getShowing().getId() == showing.getId()) {
                            countOfReservations++;
                        }
                    }
                }
            }
            Statistic statistic = new Statistic(countOfReservations, movie);
            statistics.add(statistic);
            statisticsRepository.save(statistic);
        }
        return statistics;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/statistics")
    public @ResponseBody
    List<Statistic> getStatistics() {
        return statisticsRepository.findAll();
    }
}
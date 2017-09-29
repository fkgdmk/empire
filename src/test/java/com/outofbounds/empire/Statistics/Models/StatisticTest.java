package com.outofbounds.empire.Statistics.Models;

import com.outofbounds.empire.Movies.Models.Movie;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Anders on 29-Sep-17.
 */
public class StatisticTest {
    Movie mo = new Movie("Hejhej", "spændende", 12, "Action", 12, "www");
    Statistic stat = new Statistic(5, mo);

    @Test
    public void getTotalReservations() throws Exception {
        assertEquals(5, stat.getTotalReservations());
    }

    @Test
    public void setTotalReservations() throws Exception {
        stat.setTotalReservations(2);
        assertEquals(2, stat.getTotalReservations());
    }

    @Test
    public void getMovie() throws Exception {
        assertEquals(mo, stat.getMovie());
    }

    @Test
    public void setMovie() throws Exception {
        Movie mo2 = new Movie("234", "afa", 12, "Action", 12, "www");
        stat.setMovie(mo2);
        assertEquals(mo2, stat.getMovie());
    }
}
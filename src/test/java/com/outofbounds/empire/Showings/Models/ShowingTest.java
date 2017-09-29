package com.outofbounds.empire.Showings.Models;

import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Showrooms.Models.Showroom;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Anders on 29-Sep-17.
 */
public class ShowingTest {
    Movie mo = new Movie("Hejhej", "spændende", 12, "Action", 12, "www");
    Showroom sr = new Showroom("hej", 20, 12);
    Date datetime = new Date();
    Showing sh = new Showing(mo, sr, datetime);

    @Test
    public void getId() throws Exception {
        assertEquals(0, sh.getId());
    }

    @Test
    public void setId() throws Exception {
        sh.setId(1);
        assertEquals(1, sh.getId());
    }

    @Test
    public void getMovie() throws Exception {
        assertEquals(mo, sh.getMovie());
    }

    @Test
    public void setMovie() throws Exception {
        Movie mo2 = new Movie("124", "1414", 11112, "12", 122, "14144");
        sh.setMovie(mo2);
        assertEquals(mo2, sh.getMovie());
    }

    @Test
    public void getDatetime() throws Exception {
        assertEquals(datetime, sh.getDatetime());
    }

    @Test
    public void setDatetime() throws Exception {
        Date datetime2 = new Date();
        sh.setDatetime(datetime2);
        assertEquals(datetime2, sh.getDatetime());
    }

    @Test
    public void getShowroom() throws Exception {
        assertEquals(sr, sh.getShowroom());
    }

    @Test
    public void setShowroom() throws Exception {
        Showroom sr2 = new Showroom("hejhej", 20, 20);
        sh.setShowroom(sr2);
        assertEquals(sr2, sh.getShowroom());
    }
}
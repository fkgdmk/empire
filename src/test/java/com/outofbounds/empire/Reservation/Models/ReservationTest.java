package com.outofbounds.empire.Reservation.Models;

import com.outofbounds.empire.Movies.Models.Movie;
import com.outofbounds.empire.Showings.Models.Showing;
import com.outofbounds.empire.Showrooms.Models.Showroom;
import org.junit.Assert;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Anders on 29-Sep-17.
 */
public class ReservationTest{
    Movie mo = new Movie("Hejhej", "spændende", 12, "Action", 12, "www");
    Showroom sr = new Showroom("hej", 20, 12);
    Date datetime = new Date();
    Showing sh = new Showing(mo, sr, datetime);
    Reservation rs = new Reservation(sh, 1, "1212");

    public ReservationTest() throws Exception {
    }

    @Test
    public void getPhoneNumber() throws Exception {
        assertEquals("1212", rs.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() throws Exception {
        rs.setPhoneNumber("141461");
        assertEquals("141461", rs.getPhoneNumber());
    }

    @Test
    public void getId() throws Exception {
        assertEquals(0, rs.getId());
    }

    @Test
    public void setId() throws Exception {
        rs.setId(1);
        assertEquals(1, rs.getId());
    }

    @Test
    public void getShowing() throws Exception {
        assertEquals(sh, rs.getShowing());
    }

    @Test
    public void setShowing() throws Exception {
        Movie mo2 = new Movie("Hejhe12j", "spænde12nde", 122, "Act1ion", 112, "ww2w");
        Showroom sr2 = new Showroom("yoyo", 20, 20);
        Date datetime2 = new Date();
        Showing sh2 = new Showing(mo2, sr2, datetime2);

        rs.setShowing(sh2);
        assertEquals(sh2, rs.getShowing());
    }

    @Test
    public void getSeat() throws Exception {
        assertEquals(1, rs.getSeat());
    }

    @Test
    public void setSeat() throws Exception {
        rs.setSeat(2);
        assertEquals(2, rs.getSeat());
    }
}
package com.outofbounds.empire.Showrooms.Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Anders on 29-Sep-17.
 */
public class ShowroomTest {
    Showroom sr = new Showroom("hej", 20, 12);

    @Test
    public void getId() throws Exception {
        assertEquals(0, sr.getId());
    }

    @Test
    public void setId() throws Exception {
        sr.setId(2);
        assertEquals(2, sr.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("hej", sr.getName());
    }

    @Test
    public void setName() throws Exception {
        sr.setName("hehej");
        assertEquals("hehej", sr.getName());
    }

    @Test
    public void getWidth() throws Exception {
        assertEquals(20, sr.getWidth());
    }

    @Test
    public void setWidth() throws Exception {
        sr.setWidth(200);
        assertEquals(200, sr.getWidth());
    }

    @Test
    public void getHeight() throws Exception {
        assertEquals(12, sr.getHeight());
    }

    @Test
    public void setHeight() throws Exception {
        sr.setHeight(1414);
        assertEquals(1414, sr.getHeight());
    }
}
package com.outofbounds.empire.Customers.Models;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
    Customer cus = new Customer("28","NAME!");
    @Test //kan ikke testes da det autogenereres?
    public void getId() throws Exception {
        cus.setId(23);
        assertEquals(23, cus.getId());
    }

    @Test
    public void setId() throws Exception {
        cus.setId(3);
        assertEquals(3,cus.getId());
    }

    @Test
    public void getPhonumber() throws Exception{
        assertEquals("28",cus.getPhonumber());
    }

    @Test
    public void setPhonumber() throws Exception {
        cus.setPhonumber("876");
        assertEquals("876",cus.getPhonumber());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("NAME!",cus.getName());
    }

    @Test
    public void setName() throws Exception {
        cus.setName("abc");
        assertEquals("abc",cus.getName());
    }
}
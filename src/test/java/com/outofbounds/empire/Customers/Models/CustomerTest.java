package com.outofbounds.empire.Customers.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest
{
    Customer cus = new Customer("28","NAME!","www.@.com");
    @Test //kan ikke testes da det autogenereres?
    public void getId() throws Exception {
    }

    @Test
    public void setId() throws Exception {
        cus.setId(3);
        assertEquals(3,cus.getId());
    }

    @Test
    public void getPhonumber() throws Exception{
        
    }

    @Test
    public void setPhonumber() throws Exception
    {
    }

    @Test
    public void getName() throws Exception
    {
    }

    @Test
    public void setName() throws Exception
    {
    }

    @Test
    public void getEmail() throws Exception
    {
    }

    @Test
    public void setEmail() throws Exception
    {
    }

}
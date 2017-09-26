package com.outofbounds.empire.Showrooms.Models;

import javax.persistence.*;

@Entity
@Table(name = "showrooms")
public class Showroom
{
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "width", nullable = false)
    private int width;

    @Column(name = "hight", nullable = false)
    private int hight;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHight()
    {
        return hight;
    }

    public void setHight(int hight)
    {
        this.hight = hight;
    }
}

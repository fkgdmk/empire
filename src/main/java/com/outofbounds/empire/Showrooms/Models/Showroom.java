package com.outofbounds.empire.Showrooms.Models;

import com.outofbounds.empire.Showings.Models.Showing;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "showrooms")
public class Showroom {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "showroom")
    private List<Showing> showings;

    @Column(name = "width", nullable = false)
    private int width;

    @Column(name = "height", nullable = false)
    private int height;

    public Showroom(){

    }

    public Showroom(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
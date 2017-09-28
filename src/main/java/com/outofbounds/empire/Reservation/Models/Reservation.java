package com.outofbounds.empire.Reservation.Models;

import com.outofbounds.empire.Showings.Models.Showing;
import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "showing.id", nullable = false)
    private Showing showing;
    @Column(name = "seat_number")
    private int seat;
    @Column(name = "customers")
    private String phoneNumber;






    public Reservation(Showing showing, int seat, String phoneNumber) {
        this.showing = showing;
        this.seat = seat;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}

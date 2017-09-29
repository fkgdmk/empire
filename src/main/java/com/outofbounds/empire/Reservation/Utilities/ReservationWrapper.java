package com.outofbounds.empire.Reservation.Utilities;

import java.util.List;

public class ReservationWrapper {

    String phone;

    String name;

    Integer showingId;

    List<Integer> seat;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShowingId() {
        return showingId;
    }

    public void setShowingId(Integer showingId) {
        this.showingId = showingId;
    }

    public List<Integer> getSeat() {
        /*
        List<Integer> tempSeats = new ArrayList<>();
        tempSeats.add(1);
        tempSeats.add(2);
        tempSeats.add(3);
        return tempSeats;
        */
        return seat;
    }

    public void setSeat(List<Integer> seat) {
        this.seat = seat;
    }
}

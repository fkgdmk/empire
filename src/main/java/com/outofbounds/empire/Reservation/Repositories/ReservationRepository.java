package com.outofbounds.empire.Reservation.Repositories;

import com.outofbounds.empire.Reservation.Models.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
    public List<Reservation> findAll();

    public Reservation findById(int Id);
}

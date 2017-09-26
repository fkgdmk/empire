package com.outofbounds.empire.Showrooms.Repositories;


import com.outofbounds.empire.Seats.Models.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface SeatRepository extends CrudRepository<Seat, Integer>
{

    public List<Seat> findAll();

    public Seat findById(int Id);
}

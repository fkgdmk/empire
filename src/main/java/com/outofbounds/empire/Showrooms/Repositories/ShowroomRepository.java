package com.outofbounds.empire.Showrooms.Repositories;

import com.outofbounds.empire.Showrooms.Models.Showroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ShowroomRepository extends CrudRepository<Showroom, Integer>
{
    public List<Showroom> findAll();

    public Showroom findById(int Id);
}

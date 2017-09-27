package com.outofbounds.empire.Showings.Repositories;

import com.outofbounds.empire.Showings.Models.Showing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anders on 26-Sep-17.
 */
@Transactional
@Repository
public interface ShowingRepository extends CrudRepository<Showing, Integer> {
    public List<Showing> findAll();

    public Showing findById(int Id);
}

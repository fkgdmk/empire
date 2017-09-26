package com.outofbounds.empire.Showings.Repositories;

import com.outofbounds.empire.Movies.Models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Anders on 26-Sep-17.
 */
@Transactional
@Repository
public interface ShowingRepository extends CrudRepository<Movie, Integer>
{

    public List<Movie> findAll();

    public Movie findById(int Id);
}

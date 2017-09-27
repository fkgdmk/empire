package com.outofbounds.empire.Movies.Repositories;

import com.outofbounds.empire.Movies.Models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

    public List<Movie> findAll();

    public Movie findById(int Id);
}

package com.outofbounds.empire.Statistics.Repositories;

import com.outofbounds.empire.Statistics.Models.Statistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public interface StatisticsRepository extends CrudRepository<Statistics, Integer> {
    public List<Statistics> findAll();
    public Statistics findById(int Id);
    public Statistics findBymovieID(int movieID);
}
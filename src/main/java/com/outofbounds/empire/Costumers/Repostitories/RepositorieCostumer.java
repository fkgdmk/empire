package com.outofbounds.empire.Costumers.Repostitories;

import com.outofbounds.empire.Movies.Models.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.outofbounds.empire.Costumers.Models.CostumerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface RepositorieCostumer extends CrudRepository<CostumerModel, Integer> {

        public List<CostumerModel> findAll();
        public CostumerModel findById(int Id);
        public CostumerModel findByPhoneNumber(String Phonenumber);

    }



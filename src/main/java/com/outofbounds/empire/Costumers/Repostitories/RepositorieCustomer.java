package com.outofbounds.empire.Costumers.Repostitories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.outofbounds.empire.Costumers.Models.CustomerModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Transactional
@Repository
public interface RepositorieCustomer extends CrudRepository<CustomerModel, Integer> {
        public List<CustomerModel> findAll();
        public CustomerModel findById(int Id);
        public CustomerModel findByPhoneNumber(String Phonenumber);
    }
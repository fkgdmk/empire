package com.outofbounds.empire.Costumers.Repostitories;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.outofbounds.empire.Costumers.Models.Customer;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

@Transactional
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
        public List<Customer> findAll();
        public Customer findById(int Id);
        public Customer findByPhoneNumber(String phoneNumber);
    }
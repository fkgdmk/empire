package com.outofbounds.empire.Customers.Controllers;

import com.outofbounds.empire.Customers.Repostitories.CustomerRepository;
import com.outofbounds.empire.Customers.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    public CustomerRepository customerRepository;

    /**
     * Basic route for customers
     *
     * @return customers
     */

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    public @ResponseBody
    List<Customer> customers() {
        return customerRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
    public @ResponseBody
    Customer customerModel(@PathVariable int id) {
        return customerRepository.findById(id);
    }

//    public @ResponseBody
//    Customer customerModel(@PathVariable String phoneNumber) {
//        return customerRepository.findByPhoneNumber(phoneNumber);
//    }

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.PUT, value = ("/customers/{id}"))
    public @ResponseBody
    Customer updateCustomer(
            @PathVariable int id,
            @RequestParam (required = false) String phonenumber,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String email
    )
    {
        Customer customer = customerRepository.findById(id);

        try {
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhonumber(phonenumber);

        } catch (NullPointerException e) {
        }
        customerRepository.save(customer);
        return customer;
    }
}
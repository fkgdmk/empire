package com.outofbounds.empire.Costumers.Controllers;

import com.outofbounds.empire.Costumers.Repostitories.CustomerRepository;
import com.outofbounds.empire.Costumers.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    public CustomerRepository customerRepository;

    /**
     * Basic route for costumers
     *
     * @return costumers
     */

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "??"/*todo*/)

    public @ResponseBody
    List<Customer> costumers() {
        return customerRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public @ResponseBody
    Customer costumerModel(@PathVariable int id) {
        return customerRepository.findById(id);
    }

    public @ResponseBody
    Customer costumerModel(@PathVariable String phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    @RequestMapping(method = RequestMethod.PUT, value = (""))/*todo*/
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
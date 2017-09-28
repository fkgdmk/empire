package com.outofbounds.empire.Costumers.Controllers;

import com.outofbounds.empire.Costumers.Repostitories.RepositorieCustomer;
import com.outofbounds.empire.Costumers.Models.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Customerscontroller {

    @Autowired
    public RepositorieCustomer repositorieCustomer;

    /**
     * Basic route for costumers
     *
     * @return costumers
     */

    @CrossOrigin(origins = "http://localhost:8000")
    @RequestMapping(method = RequestMethod.GET, value = "??"/*todo*/)

    public @ResponseBody
    List<CustomerModel> costumers() {

        return repositorieCustomer.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "")

    public @ResponseBody
    CustomerModel costumerModel(@PathVariable int id) {
        return repositorieCustomer.findById(id);
    }

    public @ResponseBody
    CustomerModel costumerModel(@PathVariable String phoneNumber) {
        return repositorieCustomer.findByPhoneNumber(phoneNumber);
    }

    @RequestMapping(method = RequestMethod.PUT, value = (""))/*todo*/
    public @ResponseBody
    CustomerModel updateCustomer(
            @PathVariable int id,
            @RequestParam (required = false) String phonenumber,
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String email
    )
    {
        CustomerModel customer = repositorieCustomer.findById(id);

        try {
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhonumber(phonenumber);

        } catch (NullPointerException e) {
        }
        repositorieCustomer.save(customer);
        return customer;
    }
}
package com.marcobehler.springbootdemo.controller;

import com.marcobehler.springbootdemo.domain.Customer;
import com.marcobehler.springbootdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@RestController(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> customers() {
        return service.findAllCustomers();
    }

    @PostMapping // HTTP post
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @PutMapping // HTTP put
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }
}

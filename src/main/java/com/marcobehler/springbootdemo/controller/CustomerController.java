package com.marcobehler.springbootdemo.controller;

import com.marcobehler.springbootdemo.domain.Customer;
import com.marcobehler.springbootdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@RestController(value = "/customers")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService service;


    // Map<CustomerId,Etag>
     // TODO DOCS!

    @GetMapping
    public Page<Customer> customers(Pageable pageable) { // http://....../?sort=property,asc|desc
        return service.findAllCustomers(pageable);
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable Integer customerId) {
        return service.getCustomer(customerId);
    }

    @PostMapping // HTTP post
    public Customer createCustomer(@RequestBody Customer customer) {
        return service.createCustomer(customer);
    }

    @PutMapping("/customers/{customerId}") // HTTP put
    public Customer updateCustomer(@PathVariable Integer customerId, @RequestBody Customer customer) {
        return service.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/customers/{customerId}") // HTTP delete
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer customerId) {
        service.deleteCustomer(customerId);
    }

}

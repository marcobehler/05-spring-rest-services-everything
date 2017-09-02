package com.marcobehler.springbootdemo.service;

import com.marcobehler.springbootdemo.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@Service
public class CustomerService {

    private List<Customer> customerDb = new ArrayList<>();

    public List<Customer> findAllCustomers() {
        return customerDb;
    }

    public Customer createCustomer(Customer customer) {
        // later on, we will do real DB calls here...!!
        customer.setId(ThreadLocalRandom.current().nextInt());
        customerDb.add(customer);
        return customer;
    }
}

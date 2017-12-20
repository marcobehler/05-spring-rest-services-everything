package com.marcobehler.springbootdemo.service;

import com.marcobehler.springbootdemo.controller.ResourceNotFoundException;
import com.marcobehler.springbootdemo.domain.Customer;
import com.marcobehler.springbootdemo.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Integer customerId) {
        return customerRepository.findOne(customerId);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Integer customerId, Customer customer) { // TODO DTO and Validation.....
        throw new UnsupportedOperationException("todo");
    }

    public void deleteCustomer(Integer customerId) {
        throw new UnsupportedOperationException("not yet implemented");
    }

}

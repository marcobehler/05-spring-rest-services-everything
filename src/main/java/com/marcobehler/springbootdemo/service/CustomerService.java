package com.marcobehler.springbootdemo.service;

import com.marcobehler.springbootdemo.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers(Sort sort) {
        return customerRepository.findAll(sort);
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

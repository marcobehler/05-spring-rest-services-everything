package com.marcobehler.springbootdemo.service;

import com.marcobehler.springbootdemo.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@Service
public class CustomerService {

    public List<Customer> findAllCustomers() {
        return Collections.emptyList();
    }
}

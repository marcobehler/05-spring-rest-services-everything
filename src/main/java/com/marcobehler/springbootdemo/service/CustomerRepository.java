package com.marcobehler.springbootdemo.service;

import com.marcobehler.springbootdemo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // custom methods here...

    // TODO ordering, sorting!
}

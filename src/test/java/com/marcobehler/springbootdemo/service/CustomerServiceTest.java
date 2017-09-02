package com.marcobehler.springbootdemo.service;


import com.marcobehler.springbootdemo.domain.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
public class CustomerServiceTest {

    private CustomerService service;

    @Before
    public void setUp() throws Exception {
        service = new CustomerService();
    }

    @Test
    public void finds_no_customers_with_empty_db() throws Exception {
        assertThat(service.findAllCustomers()).isEmpty();
    }

    @Test
    public void create_new_customer() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Snow");

        assertThat(service.findAllCustomers()).isEmpty(); // no customer saved yet!

        Customer savedCustomer = service.createCustomer(customer);

        assertThat(savedCustomer.getId()).isNotNull();
        assertThat(service.findAllCustomers()).hasSize(1);

    }
}
package com.marcobehler.springbootdemo.service;


import com.marcobehler.springbootdemo.controller.ResourceNotFoundException;
import com.marcobehler.springbootdemo.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(CustomerService.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService service;


    @Autowired
    private JdbcTemplate template;

    @Before
    public void setUp() throws Exception {
        template.update("truncate table customers");
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

    @Test
    public void updateCustomer_works_for_existing_customer() throws Exception {
        Integer customerId = service.createCustomer(Customer.builder().firstName("John").lastName("Snow").build()).getId();

        Customer updatedCustomer = service.updateCustomer(customerId, Customer.builder().id(customerId).firstName("Aegon").lastName("Targaryen").build());

        assertThat(updatedCustomer.getId()).isEqualTo(customerId);
        assertThat(updatedCustomer.getFirstName()).isEqualTo("Aegon");
        assertThat(updatedCustomer.getLastName()).isEqualTo("Targaryen");
    }

    @Test(expected = ResourceNotFoundException.class)
    public void updateCustomer_fails_for_non_existing_id() throws Exception {
        service.updateCustomer(ThreadLocalRandom.current().nextInt(), Customer.builder().firstName("Aegon").lastName("Targaryen").build());
    }


    @Test
    public void getCustomer_works_for_existing_Customer() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Snow");
        Integer customerId = service.createCustomer(customer).getId();

        Customer savedCustomer = service.getCustomer(customerId);

        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getId()).isEqualTo(customerId);
        assertThat(savedCustomer.getFirstName()).isEqualTo("John");
    }
}
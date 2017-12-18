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
    private DataSource dataSource; // should be an h2 datasource

    @Autowired
    private JdbcTemplate jdbcTemplate; // allows you to execute sql!


    public List<Customer> findAllCustomers() {
        return jdbcTemplate.query("select id, first_name, last_name, birth_date, status from customers",
                this::customerMapper);
    }

    public Customer getCustomer(Integer customerId) {
        return jdbcTemplate.queryForObject("select id, first_name, last_name, birth_date, status from customers where id = ?",
                new Object[]{customerId}, this::customerMapper);
    }

    private Customer customerMapper(ResultSet resultSet, int i) throws SQLException {
        Customer c = new Customer();
        c.setId(resultSet.getInt("id"));
        c.setFirstName(resultSet.getString("first_name"));
        c.setLastName(resultSet.getString("last_name"));
        if (resultSet.getDate("birth_date") != null) {
            c.setBirthDate(resultSet.getDate("birth_date").toLocalDate());
        }
        if (resultSet.getString("status") != null) {
            c.setStatus(Status.valueOf(resultSet.getString("status")));
        }
        return c;
    }

    public Customer createCustomer(Customer customer) {
        int id = ThreadLocalRandom.current().nextInt();
        customer.setId(id);
        jdbcTemplate.update("insert into customers (id, first_name, last_name, birth_date, status) VALUES (?,?,?,?,?)",
                id, customer.getFirstName(), customer.getLastName(), customer.getBirthDate(), customer.getStatus());
        return customer;
    }

    public Customer updateCustomer(Integer customerId, Customer customer) { // TODO DTO and Validation.....
        int updateCount = jdbcTemplate.update("update customers set first_name = ?, last_name = ?, birth_date = ?, status = ? where id = ?",
                customer.getFirstName(), customer.getLastName(), customer.getBirthDate(), customer.getStatus(), customerId);
        if (updateCount == 0) {
            throw new ResourceNotFoundException();
        }
        return customer;
    }

    public void deleteCustomer(Integer customerId) {
        throw new UnsupportedOperationException("not yet implemented");
    }

}

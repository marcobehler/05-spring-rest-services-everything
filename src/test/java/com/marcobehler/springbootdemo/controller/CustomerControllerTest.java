package com.marcobehler.springbootdemo.controller;

import com.marcobehler.springbootdemo.domain.Customer;
import com.marcobehler.springbootdemo.domain.Status;
import com.marcobehler.springbootdemo.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;


    @Test
    public void controller_can_serialize_customers() throws Exception {
        Customer customer = new Customer();
        customer.setBirthDate(LocalDate.of(2017, 1, 1));
        customer.setFirstName("John");
        customer.setLastName("Snow");
        customer.setStatus(Status.FRAUDSTER);

        given(this.customerService.findAllCustomers())
                .willReturn(Arrays.asList(customer));

        this.mvc.perform(get("/customers").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().json("[\n" +
                "  {\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"Snow\",\n" +
                "    \"status\": \"FRAUDSTER\",\n" +
                "    \"birthDate\": \"01.01.2017\"\n" +
                "  }\n" +
                "]"));
    }

    // TODO write more tests...
}
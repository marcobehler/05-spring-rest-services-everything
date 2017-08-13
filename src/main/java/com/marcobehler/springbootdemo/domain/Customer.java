package com.marcobehler.springbootdemo.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Thanks for watching this episode! Send any feedback to info@marcobehler.com!
 */
@Getter
@Setter
public class Customer {

    private Integer id;

    private String firstName;

    private String lastName;

    private Status status;

    private LocalDate birthDate;
}

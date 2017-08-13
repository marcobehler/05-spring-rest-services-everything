package com.marcobehler.springbootdemo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthDate;
}

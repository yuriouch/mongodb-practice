package com.ouch.mongodbpractice.dto;

import java.time.LocalDate;
import java.util.List;

public class AuthorDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate dateOfBirth;
    private List<Object> books;
}

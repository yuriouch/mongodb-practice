package com.ouch.mongodbpractice.model;

import java.time.LocalDate;
import java.util.List;

public class Author {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate dateOfBirth;
    private List<Object> books;
}

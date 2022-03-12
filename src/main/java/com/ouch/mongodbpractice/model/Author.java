package com.ouch.mongodbpractice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "authors")
public class Author {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate dateOfBirth;
    private List<Object> books;

    public Author(String firstName, String lastName, Integer age, LocalDate dateOfBirth, List<Object> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.books = books;
    }
}

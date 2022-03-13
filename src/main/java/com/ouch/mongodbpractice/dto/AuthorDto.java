package com.ouch.mongodbpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class AuthorDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate dateOfBirth;
    private List<Object> books;
}

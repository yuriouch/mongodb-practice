package com.ouch.mongodbpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class AuthorDto {
    private String firstName;
    private String lastName;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private List<BookDto> books;
}

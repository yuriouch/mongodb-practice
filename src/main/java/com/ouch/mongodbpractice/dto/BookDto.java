package com.ouch.mongodbpractice.dto;

import com.ouch.mongodbpractice.model.CoverType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookDto {
    private String isbn;
    private String title;
    private String description;
    private CoverType coverType;
    private Integer numberOfPages;
    private Double weight;
    private List<AuthorDto> authors;
}

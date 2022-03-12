package com.ouch.mongodbpractice.dto;

import com.ouch.mongodbpractice.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookInfoDto {
    private String title;
    private String description;
    private Integer numberOfPages;
    private Double weight;
    private List<Author> authors;
}

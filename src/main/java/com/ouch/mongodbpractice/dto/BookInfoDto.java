package com.ouch.mongodbpractice.dto;

import com.ouch.mongodbpractice.model.Author;

import java.util.List;

public class BookInfoDto {
    private String title;
    private String description;
    private Integer numberOfPages;
    private Double weight;
    private List<Author> authors;
}

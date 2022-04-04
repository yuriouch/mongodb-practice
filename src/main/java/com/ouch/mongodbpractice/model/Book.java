package com.ouch.mongodbpractice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "books")
public class Book {
    private String id;
    private String isbn;
    private String title;
    private String description;
    private CoverType coverType;
    private Integer numberOfPages;
    private Double weight;
    private List<Author> authors;

    public Book(String isbn, String title, String description, CoverType coverType, Integer numberOfPages, Double weight, List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.coverType = coverType;
        this.numberOfPages = numberOfPages;
        this.weight = weight;
        this.authors = authors;
    }
}

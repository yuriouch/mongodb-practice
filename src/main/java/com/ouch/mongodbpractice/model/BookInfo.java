package com.ouch.mongodbpractice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "books")
public class BookInfo {
    private String id;
    private String title;
    private String description;
    private Integer numberOfPages;
    private Double weight;
    private List<Author> authors;

    public BookInfo(String title, String description, Integer numberOfPages, Double weight, List<Author> authors) {
        this.title = title;
        this.description = description;
        this.numberOfPages = numberOfPages;
        this.weight = weight;
        this.authors = authors;
    }
}

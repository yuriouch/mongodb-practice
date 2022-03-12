package com.ouch.mongodbpractice.model;

import java.util.List;

public class BookInfo {
    private String id;
    private String title;
    private String description;
    private Integer numberOfPages;
    private Double weight;
    private List<Author> authors;
}

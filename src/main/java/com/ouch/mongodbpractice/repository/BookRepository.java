package com.ouch.mongodbpractice.repository;

import com.ouch.mongodbpractice.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, String> {
    Optional<Book> findOneByIsbn(String isbn);
    List<Book> findByTitle(String title);
}

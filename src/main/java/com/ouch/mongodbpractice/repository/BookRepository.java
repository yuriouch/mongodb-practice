package com.ouch.mongodbpractice.repository;

import com.ouch.mongodbpractice.model.BookInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<BookInfo, String> {
    Optional<BookInfo> findByTitle(String title);
}

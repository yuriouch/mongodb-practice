package com.ouch.mongodbpractice.repository;

import com.ouch.mongodbpractice.model.BookInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookInfo, String> {
}

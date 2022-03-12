package com.ouch.mongodbpractice.repository;

import com.ouch.mongodbpractice.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
}

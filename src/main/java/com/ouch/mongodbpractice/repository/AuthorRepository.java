package com.ouch.mongodbpractice.repository;

import com.ouch.mongodbpractice.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AuthorRepository extends MongoRepository<Author, String> {
    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);
}

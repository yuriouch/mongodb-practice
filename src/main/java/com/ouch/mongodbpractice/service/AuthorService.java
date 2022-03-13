package com.ouch.mongodbpractice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ouch.mongodbpractice.dto.AuthorDto;
import com.ouch.mongodbpractice.model.Author;
import com.ouch.mongodbpractice.repository.AuthorRepository;
import com.ouch.mongodbpractice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    
    private final AuthorRepository authorRepository;
    private final ObjectMapper mapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, ObjectMapper mapper) {
        this.authorRepository = authorRepository;
        this.mapper = mapper;
    }
    
    public AuthorDto getAuthorById(String id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.map(a -> mapper.convertValue(a, AuthorDto.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public AuthorDto getAuthorByFirstNameAndLastName(String firstName, String lastName) {
        Optional<Author> author = authorRepository.findAuthorByFirstNameAndLastName(firstName, lastName);
        return author.map(a -> mapper.convertValue(a, AuthorDto.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(author -> mapper.convertValue(author, AuthorDto.class))
                .collect(Collectors.toList());
    }

    public AuthorDto saveAuthor(AuthorDto authorDto) {
        Author author = mapper.convertValue(authorDto, Author.class);
        return mapper.convertValue(authorRepository.save(author), AuthorDto.class);
    }

    public void deleteAuthorById(String id) {
        authorRepository.deleteById(id);
    }
}

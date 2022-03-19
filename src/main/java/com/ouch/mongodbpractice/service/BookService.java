package com.ouch.mongodbpractice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ouch.mongodbpractice.dto.BookDto;
import com.ouch.mongodbpractice.model.Book;
import com.ouch.mongodbpractice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    
    private final BookRepository bookRepository;
    private final ObjectMapper mapper;

    @Autowired
    public BookService(BookRepository bookRepository, ObjectMapper mapper) {
        this.bookRepository = bookRepository;
        this.mapper = mapper;
    }

    public BookDto getBookById(String id) {
        Optional<Book> bookInfo = bookRepository.findById(id);
        return bookInfo.map(book -> mapper.convertValue(book, BookDto.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public BookDto getBookByTitle(String title) {
        Optional<Book> bookInfo = bookRepository.findByTitle(title);
        return bookInfo.map(book -> mapper.convertValue(book, BookDto.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> mapper.convertValue(book, BookDto.class))
                .collect(Collectors.toList());
    }

    public BookDto saveBook(BookDto bookDto) {
        Book book = mapper.convertValue(bookDto, Book.class);
        return mapper.convertValue(bookRepository.save(book), BookDto.class);
    }

    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }
}

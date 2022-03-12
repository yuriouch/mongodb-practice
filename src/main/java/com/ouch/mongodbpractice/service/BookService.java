package com.ouch.mongodbpractice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ouch.mongodbpractice.dto.BookInfoDto;
import com.ouch.mongodbpractice.model.BookInfo;
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

    public BookInfoDto getBookById(String id) {
        Optional<BookInfo> bookInfo = bookRepository.findById(id);
        return bookInfo.map(book -> mapper.convertValue(book, BookInfoDto.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public BookInfoDto getBookByTitle(String title) {
        Optional<BookInfo> bookInfo = bookRepository.findByTitle(title);
        return bookInfo.map(book -> mapper.convertValue(book, BookInfoDto.class))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    
    public List<BookInfoDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> mapper.convertValue(book, BookInfoDto.class))
                .collect(Collectors.toList());
    }

    public BookInfoDto saveBook(BookInfoDto bookInfoDto) {
        BookInfo bookInfo = mapper.convertValue(bookInfoDto, BookInfo.class);
        return mapper.convertValue(bookRepository.save(bookInfo), BookInfoDto.class);
    }

    public void deleteBookById(String id) {
        bookRepository.deleteById(id);
    }
}

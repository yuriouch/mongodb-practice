package com.ouch.mongodbpractice.controller;

import com.ouch.mongodbpractice.dto.BookInfoDto;
import com.ouch.mongodbpractice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{id}")
    public BookInfoDto getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/books/param")
    public BookInfoDto getBookByTitle(@RequestParam String title) {
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/books")
    public List<BookInfoDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public BookInfoDto saveBook(@RequestBody BookInfoDto bookInfoDto) {
        return bookService.saveBook(bookInfoDto);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable String id) {
        bookService.deleteBookById(id);
    }
}

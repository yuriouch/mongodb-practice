package com.ouch.mongodbpractice.controller;

import com.ouch.mongodbpractice.dto.AuthorDto;
import com.ouch.mongodbpractice.service.AuthorService;
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
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors/{id}")
    public AuthorDto getAuthorById(@PathVariable String id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/authors/param")
    public AuthorDto getAuthorByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return authorService.getAuthorByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/authors")
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/authors")
    public AuthorDto saveAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.saveAuthor(authorDto);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthorById(@PathVariable String id) {
        authorService.deleteAuthorById(id);
    }
}

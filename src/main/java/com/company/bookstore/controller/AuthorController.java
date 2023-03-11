package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.company.bookstore.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;


@RestController
public class AuthorController {

    @Autowired
    AuthorRepository authorRepo;

    //Create new Author
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author){
        return  authorRepo.save(author);
    }

    //Update existing author
    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public Author putAuthor(@RequestBody Author author){
        return authorRepo.save(author);
    }

    //Read by ID
    @GetMapping("/authors/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Author> findAuthorById(@PathVariable Integer authorId){
        return authorRepo.findById(authorId);
    }

    //Read all
    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors(){
        return authorRepo.findAll();
    }

    @DeleteMapping("/authors/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteAuthor(@PathVariable Integer authorId){
        authorRepo.deleteById(authorId);
    }
}
package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepo;

    // Create a Book
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    // Read by Id
    @GetMapping("/books/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book getBookById(@PathVariable Integer id) {
        Optional<Book> returnVal = bookRepo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    // Read all
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    // Update
    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Book updateBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    // Delete
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
        bookRepo.deleteById(id);
    }

    // Search Book by Author Id
    @GetMapping("/books/author/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> findBookByAuthorId(@PathVariable Integer id) {
        List<Book> bookList = new ArrayList<>();
        for (Book b: bookRepo.findAll()) {
            if (b.getAuthorId() == id) {
                bookList.add(b);
            }
        }
        return bookList;
    }
}

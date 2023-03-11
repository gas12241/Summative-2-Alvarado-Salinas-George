package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.AuthorRepository;
import com.company.bookstore.repository.BookRepository;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class GraphController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @QueryMapping
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @QueryMapping
    public List<Publisher> publishers() {
        return publisherRepository.findAll();
    }

    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Publisher findPublisherById(@Argument Integer publisher_id) {
        Optional<Publisher> publisher = publisherRepository.findById(publisher_id);
        if (publisher.isPresent()) {
            return publisher.get();
        } else {
            return null;
        }
    }


    @QueryMapping
    public Optional<Author> findAuthorById(@Argument Integer author_id) {
        return authorRepository.findById(author_id);
    }

    @QueryMapping
    public Book findBookById(@Argument Integer book_id) {
        Optional<Book> book = bookRepository.findById(book_id);
        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }
}

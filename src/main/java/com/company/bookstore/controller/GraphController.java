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
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

/**
 * GraphController class that will be used to
 * display information using GraphQL.
 */
@Controller
public class GraphController {

    /**
     * authorRepository that will be used
     * by the methods to get information from
     * the Database.
     */
    @Autowired
    AuthorRepository authorRepository;

    /**
     * bookRepository that will be used
     * by the methods to get information from
     * the Database.
     */
    @Autowired
    BookRepository bookRepository;

    /**
     * publisherRepository that will be used
     * by the methods to get information from
     * the Database.
     */
    @Autowired
    PublisherRepository publisherRepository;

    /**
     * GraphQL method to get all the Authors from the Database.
     * @return Returns all the Authors from the authorRepository.
     */
    @QueryMapping
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    /**
     * GraphQL method to get all the Publishers from the Database.
     * @return Returns all the Publishers from the
     *         publisherRepository.
     */
    @QueryMapping
    public List<Publisher> publishers() {
        return publisherRepository.findAll();
    }

    /**
     * GraphQL method to get all the books from the Database.
     * @return Returns all the Books in the bookRepository.
     */
    @QueryMapping
    public List<Book> books() {
        return bookRepository.findAll();
    }

    /**
     * GraphQL method to find a Publisher by its Id.
     * @param publisher_id publisher_id that will be used to find
     *                     a specific Publisher from the Database.
     * @return Returns a Publisher with the given Id from the
     *         Database if it exists, otherwise it returns a null
     *         value.
     */
    @QueryMapping
    public Publisher findPublisherById(@Argument Integer publisher_id) {
        Optional<Publisher> publisher = publisherRepository.findById(publisher_id);
        if (publisher.isPresent()) {
            return publisher.get();
        } else {
            return null;
        }
    }


    /**
     * GraphQL method to find an Author by its Id.
     * @param author_id author_id that will be used to get
     *                  an Author from the Database.
     * @return Returns an Author with the given Id IF the Author
     *         exists in the Database, otherwise it returns a null
     *         value.
     */
    @QueryMapping
    public Optional<Author> findAuthorById(@Argument Integer author_id) {
        return authorRepository.findById(author_id);
    }

    /**
     * GraphQL's method to find a Book by its Id.
     * @param book_id book_id that will be used to get a Book
     *                from the Database.
     * @return Returns a Book with the given Id IF the Book exists
     *         in the Database, otherwise it returns a null value.
     */
    @QueryMapping
    public Book findBookById(@Argument Integer book_id) {
        Optional<Book> book = bookRepository.findById(book_id);
        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
    }

    /**
     * NOTE: This code was given to me by Jessie. He let me know that this
     *       was something he got from office hours from a TA, and it allowed
     *       him to get the Publisher from a Book.
     * @param book Book being used to get the Publisher from.
     * @return Returns a Publisher from the book if present, else you get
     *         a null value.
     */
    @SchemaMapping
    public Publisher publisher(Book book) {
        Optional<Publisher> returnVal = publisherRepository.findById(book.getPublisherId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    /**
     * NOTE: This code was given to me by Jessie. He let me know that this
     *       was something he got from office hours from a TA, and it allowed
     *       him to get the Author from a Book.
     * Should get an Author by the Book's authorId.
     * @param book book that will be used to check for the author.
     * @return Returns an Author by a given Book id if the Author exists.
     */
    @SchemaMapping
    public Author author(Book book) {
        Optional<Author> returnVal = authorRepository.findById(book.getAuthorId());
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }
}

package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * BookController class that will be used the Bookstore Application.
 */
@RestController
public class BookController {

    /**
     * bookRepo that will be used in each method to get back some
     * information from the Database.
     */
    @Autowired
    BookRepository bookRepo;

    /**
     * Creates a Book using a Post method.
     * @param book book taken in will be used to create a new
     *             book in the bookRepo.
     * @return Returns the book that you inserted, letting you know
     *         that the book inserted was done so successfully.
     */
    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    /**
     * Gets a specific Book using the Id given.
     * @param id id will be used to check the bookRepo for a
     *           specific Book.
     * @return Returns the Book by the given Id if the book
     *         exists in the bookRepo.
     */
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

    /**
     * Gets all the books in the Book Repo using a Get method.
     * @return Returns all the books in the bookRepo.
     */
    @GetMapping("/books")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Book> getBooks() {
        return bookRepo.findAll();
    }

    /**
     * Updates a book with the given Id using a Put method.
     * @param book book that will be updated in the Database.
     *             Should have the Id inside along with anything
     *             else that should be updated.
     * @return Returns the book that you were trying to update,
     *         allowing you to make sure you updated correctly.
     */
    @PutMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Book updateBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    /**
     * Deletes a book by the given Id.
     * @param id id that will be used to delete a specific Book.
     */
    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
        bookRepo.deleteById(id);
    }

    /**
     * Gets the Books by a given Author Id.
     * @param id Author Id being used to check for books.
     * @return Returns Books by an author given the AuthorId.
     */
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

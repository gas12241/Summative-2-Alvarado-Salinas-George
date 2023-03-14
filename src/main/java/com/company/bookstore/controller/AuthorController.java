package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.company.bookstore.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

/**
 * Author controller that will be used to get the Authors in a Bookstore Application.
 */
@RestController
public class AuthorController {

    /**
     * Repo being used in the controller. Acts as the Repo for the Authors.
     */
    @Autowired
    AuthorRepository authorRepo;

    /**
     * Creates an Author using a Post method.
     * @param author Author object that will be used to create a new Author in the
     *               Bookstore Application.
     * @return Returns the Author you put in confirming it was posted successfully.
     */
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public Author addAuthor(@RequestBody Author author){
        return  authorRepo.save(author);
    }

    /**
     * Updates an Author using a Put method.
     * @param author Takes in an Author (Should have the id inside) that
     *               would be used to update it using the Id.
     * @return Returns the Author that you just updated, letting you know what
     *         changed.
     */
    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public Author putAuthor(@RequestBody Author author){
        return authorRepo.save(author);
    }

    /**
     * Gets an Author with a specific Id.
     * @param authorId authorId being used to find a specific Author.
     * @return Returns the Author by Id, if it exists in the Database.
     */
    @GetMapping("/authors/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Author> findAuthorById(@PathVariable Integer authorId){
        return authorRepo.findById(authorId);
    }

    /**
     * Gets all Authors in the Database.
     * @return Returns all the authors found in the Author Repository.
     */
    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Author> getAllAuthors(){
        return authorRepo.findAll();
    }

    /**
     * Deletes an Author using the given Id.
     * @param authorId authorId that will be used to delete an Author
     *                 in the Author Repository.
     */
    @DeleteMapping("/authors/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteAuthor(@PathVariable Integer authorId){
        authorRepo.deleteById(authorId);
    }
}
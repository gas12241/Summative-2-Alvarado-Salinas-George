package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Publisher Controller that will be used in a Bookstore Application.
 */
@RestController
public class PublisherController {

    /**
     * publisherRepo that will be used to get
     * information from the Database.
     */
    @Autowired
    PublisherRepository publisherRepo;


    /**
     * Creates a Publisher using a Post Method.
     * @param publisher publisher that will be created
     *                  in the Database.
     * @return Returns the Publisher you inputted with
     *         an Id, letting you know the post was
     *         successful.
     */
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    /**
     * Gets a specific Publisher by its given Id.
     * @param id id that will be used to get a Publisher from
     *           the Database.
     * @return Returns a Publisher by the given Id. Else, this
     *         will return a null value.
     */
    @GetMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Publisher findPublisherById(@PathVariable int id) {
        Optional<Publisher> returnVal = publisherRepo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    /**
     * Gets all the publishers from the publisherRepo.
     * @return Returns all the Publishers from
     *         the Database.
     */
    @GetMapping("/publishers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Publisher> getPublishers() {
        return publisherRepo.findAll();
    }

    /**
     * Updates a specific Publisher using a Given Publisher
     * as an input (Should have the Id in it as well, otherwise
     * it will post a new author with duplicate values).
     * @param publisher Publisher being used to update a specific
     *                  Publisher in the Database.
     * @return Returns the Publisher with the updated values,
     *         letting you know if the updates went in well.
     */
    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Publisher updatePublisher(@RequestBody Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    /**
     * Deletes a specific Publisher using an Id.
     * @param id id that will be used to delete a
     *           specific Publisher.
     */
    @DeleteMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        publisherRepo.deleteById(id);
    }
}

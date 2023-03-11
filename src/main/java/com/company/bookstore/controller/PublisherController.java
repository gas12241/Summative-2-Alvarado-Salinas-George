package com.company.bookstore.controller;

import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PublisherController {

    @Autowired
    PublisherRepository publisherRepo;


    // Create a Publisher
    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    // Read by Id
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

    // Read all
    @GetMapping("/publishers")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Publisher> getPublishers() {
        return publisherRepo.findAll();
    }

    // Update Publisher
    @PutMapping("/publishers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Publisher updatePublisher(@RequestBody Publisher publisher) {
        return publisherRepo.save(publisher);
    }

    // Delete Publisher
    @DeleteMapping("/publishers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable int id) {
        publisherRepo.deleteById(id);
    }
}

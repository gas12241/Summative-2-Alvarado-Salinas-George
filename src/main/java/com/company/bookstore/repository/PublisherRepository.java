package com.company.bookstore.repository;

import com.company.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * PublisherRepository class that will be used to connect
 * the PublisherController class with the Database.
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}


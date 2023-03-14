package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Author Repository that will be used to connect
 * the AuthorController to the Database.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}

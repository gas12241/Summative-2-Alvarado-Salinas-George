package com.company.bookstore.repository;

import com.company.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * BookRepository class that will be used to connect
 * the BookController class with the Database.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    /**
     * Custom Method that will get a List of books by a given authorId.
     * @param authorId authorId that will be used to get the books written
     *                 by them from the Database.
     * @return Returns a List of Books by an Author given the Id.
     */
    List<Book> findByAuthorId(int authorId);

}

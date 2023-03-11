package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import net.bytebuddy.asm.Advice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    private Author newAuthor;
    private Publisher newPublisher;
    private Book newBook;
    private LocalDate date;

    @Before
    public void setUp() throws Exception {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        publisherRepository.deleteAll();

        newAuthor = new Author();
        newAuthor.setCity("Lego City");
        newAuthor.setState("LS");
        newAuthor.setFirstName("Brick");
        newAuthor.setLastName("House");
        newAuthor.setPhone("2067257474");
        newAuthor.setEmail("brickbybrick@gmail.com");
        newAuthor.setPostalCode("98120");
        newAuthor.setStreet("Brick Street");
        authorRepository.save(newAuthor);

        newPublisher = new Publisher();
        newPublisher.setCity("Lego City");
        newPublisher.setState("LS");
        newPublisher.setEmail("breads@publisher.com");
        newPublisher.setName("Brick Reads");
        newPublisher.setPhone("2061880090");
        newPublisher.setStreet("Breads Ave");
        newPublisher.setPostalCode("98120");
        publisherRepository.save(newPublisher);


        newBook = new Book();
        newBook.setIsbn("1121134");
        newBook.setAuthorId(newAuthor.getAuthorId());
        date = LocalDate.of(2020, 10, 12);
        newBook.setPublishDate(date);
        newBook.setTitle("I stepped on a Lego, but it didn't hurt");
        newBook.setPrice(BigDecimal.valueOf(7.55));
        newBook.setPublisherId(newPublisher.getPublisherId());
        bookRepository.save(newBook);
    }

    //Create Book
    @Test
    public void addBook() {
        // No book ID, becuase the DB makes it for us
        Book book = new Book();
        book.setIsbn("100110101");
        book.setPublishDate(LocalDate.of(2020, 10, 20));
        book.setAuthorId(1345431);
        book.setTitle("Book of Thieves");
        book.setPublisherId(123345);
        book.setPrice(BigDecimal.valueOf(18.99));

        book = bookRepository.save(book);

        Optional<Book> bookFromRepo = bookRepository.findById(book.getBookId());

        assertEquals(bookFromRepo.get(), book);
    }

    //Get book by id
    @Test
    public void shouldGetSpecificBookById() {
        Optional<Book> bookFromRepo = bookRepository.findById(newBook.getBookId());
        assertEquals(bookFromRepo.get().getBookId(), newBook.getBookId());
    }

    // Get all books
    @Test
    public void shouldGetAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        assertEquals(bookList.size(), 1);
    }

    // Update Books
    @Test
    public void shouldUpdateBook() {
        newBook.setIsbn("616525434");
        newBook.setTitle("Borderlands 2");
        newBook = bookRepository.save(newBook);
        Optional<Book> bookFromRepo = bookRepository.findById(newBook.getBookId());
        assertEquals(bookFromRepo.get().getIsbn(), "616525434");
    }

    // Delete Books
    @Test
    public void shouldDeleteBook() {
        bookRepository.deleteById(newBook.getBookId());
        Optional<Book> bookFromRepo = bookRepository.findById(newBook.getBookId());
        assertFalse(bookFromRepo.isPresent());
    }

    //Get Books by author Id
    @Test
    public void shouldGetBooksByAuthorId() {
        Book book = new Book();
        book.setIsbn("100110101");
        book.setPublishDate(LocalDate.of(2019, 10, 20));
        book.setAuthorId(newAuthor.getAuthorId());
        book.setTitle("Book of Thieves");
        book.setPublisherId(newPublisher.getPublisherId());
        book.setPrice(BigDecimal.valueOf(18.99));
        book = bookRepository.save(book);

        Book book2 = new Book();
        book2.setIsbn("200202002");
        book2.setPublishDate(LocalDate.of(2020, 11, 2));
        book2.setAuthorId(newAuthor.getAuthorId());
        book2.setTitle("Book of Thieves 2: Electric Boogaloo");
        book2.setPublisherId(newPublisher.getPublisherId());
        book2.setPrice(BigDecimal.valueOf(21.99));
        book2 = bookRepository.save(book2);

        Book book3 = new Book();
        book3.setIsbn("300303003");
        book3.setPublishDate(LocalDate.of(2022, 10, 23));
        book3.setAuthorId(newAuthor.getAuthorId());
        book3.setTitle("Mike Ross the boss");
        book3.setPublisherId(newPublisher.getPublisherId());
        book3.setPrice(BigDecimal.valueOf(18.99));
        book3 = bookRepository.save(book3);

        List<Book> bList = bookRepository.findByAuthorId(newAuthor.getAuthorId());
        assertEquals(bList.size(), 4);
    }

}
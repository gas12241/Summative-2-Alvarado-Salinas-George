package com.company.bookstore.repository;

import com.company.bookstore.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    private Author newAuthor;

    @Before
    public void setUp() throws Exception {
        authorRepository.deleteAll();
    }

    @Test
    public void addAuthor() {
        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("King");
        author.setStreet("SK Street");
        author.setCity("Bainbridge");
        author.setState("WA");
        author.setPostalCode("90122");
        author.setPhone("209-787-3122");
        author.setEmail("stephenk@gmail.com");

        author = authorRepository.save(author);

        Optional<Author> authorFromRepo = authorRepository.findById(author.getAuthorId());

        assertEquals(authorFromRepo.get().getAuthorId(), author.getAuthorId());
    }

    @Test
    public void shouldUpdateAuthor() {
        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("King");
        author.setStreet("SK Street");
        author.setCity("Bainbridge");
        author.setState("WA");
        author.setPostalCode("90122");
        author.setPhone("209-787-3122");
        author.setEmail("stephenk@gmail.com");
        author = authorRepository.save(author);

        author.setFirstName("Mike");
        author.setLastName("Ross");
        author.setStreet("Main St");
        author.setCity("Boston");
        author.setState("MA");
        author.setPostalCode("12345");
        author.setPhone("101-202-3003");
        author.setEmail("mkmoney@gmail.com");
        authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());

        assertEquals(author1.get(), author);
    }

    @Test
    public void shouldGetSpecificAuthorById() {
        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("King");
        author.setStreet("SK Street");
        author.setCity("Bainbridge");
        author.setState("WA");
        author.setPostalCode("90122");
        author.setPhone("209-787-3122");
        author.setEmail("stephenk@gmail.com");
        author = authorRepository.save(author);

        Author author2 = new Author();
        author2.setFirstName("Spongebob");
        author2.setLastName("SquarePants");
        author2.setStreet("Bikini Bottom Lane");
        author2.setCity("Bikini Bottom");
        author2.setState("BL");
        author2.setPostalCode("12345");
        author2.setPhone("111-123-4567");
        author2.setEmail("ss@gmail.com");
        author2 = authorRepository.save(author2);

        Optional<Author> foundAuthor = authorRepository.findById(author.getAuthorId());

        assertEquals(foundAuthor.get(), author);
    }

    @Test
    public void shouldGetAllAuthors() {
        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("King");
        author.setStreet("SK Street");
        author.setCity("Bainbridge");
        author.setState("WA");
        author.setPostalCode("90122");
        author.setPhone("209-787-3122");
        author.setEmail("stephenk@gmail.com");
        author = authorRepository.save(author);

        Author author2 = new Author();
        author2.setFirstName("Spongebob");
        author2.setLastName("SquarePants");
        author2.setStreet("Bikini Bottom Lane");
        author2.setCity("Bikini Bottom");
        author2.setState("BL");
        author2.setPostalCode("12345");
        author2.setPhone("111-123-4567");
        author2.setEmail("ss@gmail.com");
        author2 = authorRepository.save(author2);

        List<Author> aList = authorRepository.findAll();
        assertEquals(aList.size(), 2);
    }

    @Test
    public void deleteAuthorById() {
        Author author = new Author();
        author.setFirstName("Stephen");
        author.setLastName("King");
        author.setStreet("SK Street");
        author.setCity("Bainbridge");
        author.setState("WA");
        author.setPostalCode("90122");
        author.setPhone("209-787-3122");
        author.setEmail("stephenk@gmail.com");
        author = authorRepository.save(author);

        Optional<Author> author1 = authorRepository.findById(author.getAuthorId());

        assertEquals(author1.get(), author);

        authorRepository.deleteById(author.getAuthorId());

        author1 = authorRepository.findById(author.getAuthorId());

        assertFalse(author1.isPresent());
    }
}
package com.company.bookstore.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.company.bookstore.model.Book;
import com.company.bookstore.model.Publisher;
import com.company.bookstore.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BookRepository repo;

    private ObjectMapper mapper = new ObjectMapper();
    private List<Book> bookList;

    private Book inputBook;
    private Book outputBook;

    @Before
    public void setUp() throws Exception {
        outputBook = new Book();
        outputBook.setBookId(11);
        outputBook.setIsbn("987654321");
        // outputBook.setPublishDate(LocalDate.of(2020, 10, 23));
        outputBook.setAuthorId(123654);
        outputBook.setTitle("Book of Secrets");
        outputBook.setPublisherId(1314);
        outputBook.setPrice(new BigDecimal(14.99));



        inputBook = new Book();
        inputBook.setBookId(1131);
        inputBook.setIsbn("321321321");
        // inputBook.setPublishDate(LocalDate.of(2020, 10, 23));
        inputBook.setAuthorId(619753);
        inputBook.setTitle("Theory of Lightness");
        inputBook.setPublisherId(5256);
        inputBook.setPrice(new BigDecimal(32.75));
    }

    // Test Creating a book "/books"
    @Test
    public void shouldReturnNewBookOnPost () throws Exception {
        String inputJson = mapper.writeValueAsString(inputBook);
        mockMvc.perform(post("/books").content(inputJson).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
    }


    // Test get by Id "/books/{id}"
    @Test
    public void shouldGetBookById() throws Exception {
        String outputJson = mapper.writeValueAsString(outputBook);
        mockMvc.perform(MockMvcRequestBuilders.get("/books/11")).andDo(print()).andExpect(status().isAccepted());
    }

    // Test get all books "/books"
    @Test
    public void shouldGetAllBooks() throws Exception {
        String outputJson = mapper.writeValueAsString(outputBook);
        mockMvc.perform(MockMvcRequestBuilders.get("/books")).andDo(print()).andExpect(status().isAccepted());
    }

    // Test Update a book by id "/books"
    @Test
    public void shouldUpdateBookWithId() throws Exception {
        String inputJson = mapper.writeValueAsString(inputBook);
        mockMvc.perform(put("/books")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status()
                        .isNoContent());
    }

    // Test delete book by id "/books/{id}"
    @Test
    public void shouldDeleteBookById() throws Exception {
        mockMvc.perform(delete("/books/7"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    // Test getbook by authorId "/books/author/{id}"
    @Test
    public void shouldGetBooksByAuthorId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books/author/13")).andDo(print()).andExpect(status().isAccepted());
    }


}
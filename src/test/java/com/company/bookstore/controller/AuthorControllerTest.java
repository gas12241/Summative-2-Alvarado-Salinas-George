package com.company.bookstore.controller;

import com.company.bookstore.model.Author;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.List;

import static javax.swing.UIManager.put;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AuthorController repo;

    private ObjectMapper mapper = new ObjectMapper();
    private List<Author> authorList;

    private Author inputAuthor;

    @Before
    public void setUp() throws Exception {
        inputAuthor = new Author();
        inputAuthor.setFirstName("Stephen");
        inputAuthor.setLastName("King");
        inputAuthor.setStreet("11235 12th Ave");
        inputAuthor.setCity("SacTown");
        inputAuthor.setState("California");
        inputAuthor.setPostalCode("90210");
        inputAuthor.setPhone("2129290157");
        inputAuthor.setEmail("myemail@gmail.com");
    }

    // Test Post Author "/author"
    @Test
    public void shouldReturnAuthorByPost() throws Exception {
        String inputJson = mapper.writeValueAsString(inputAuthor);
        mockMvc.perform(post("/authors").content(inputJson).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());

    }

    // Test Put Author "/author"
    @Test
    public void shouldPutAuthorById() throws Exception {
        inputAuthor.setEmail("fakeemail@gmail.com");
        inputAuthor.setCity("Atlantis");
        String inputJson = mapper.writeValueAsString(inputAuthor);
        mockMvc.perform(MockMvcRequestBuilders.put("/authors").content(inputJson).contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
    }

    // TestGetbyID "/author/{authorId}"
    @Test
    public void shouldGetById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors/121")).andDo(print()).andExpect(status().isOk());
    }

    // test Getall "/author"
    @Test
    public void shouldGetAllAuthors() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors")).andDo(print()).andExpect(status().isOk());
    }

    // Test Delete by Id "/author/{authorId}"
    @Test public void shouldDeleteAuthorById() throws Exception {
        mockMvc.perform(delete("/authors/134")).andDo(print()).andExpect(status().isNoContent());
    }
}
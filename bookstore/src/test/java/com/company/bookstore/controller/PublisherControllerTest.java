package com.company.bookstore.controller;

import com.company.bookstore.model.Publisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PublisherController repo;

    private ObjectMapper mapper = new ObjectMapper();
    private List<Publisher> publisherList;


    @Before
    public void setUp() throws Exception {
    }

    // Test Create Publisher
    @Test
    public void shouldReturnNewPublisherOnPost() throws Exception{
        // Arrange
        Publisher inputPublisher = new Publisher();
        inputPublisher.setPublisherId(121);
        inputPublisher.setName("Penguin Classics");
        inputPublisher.setStreet("Penguin Street");
        inputPublisher.setCity("Penguitopia");
        inputPublisher.setState("Club Penguin");
        inputPublisher.setPostalCode("12345");
        inputPublisher.setPhone("222-333-4444");
        inputPublisher.setEmail("pclassics@gmail.com");

        String inputJson = mapper.writeValueAsString(inputPublisher);

        mockMvc.perform(post("/publishers")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated());
    }

    // Get by Id "/publishers/{id}"
    @Test
    public void shouldReturnSpecificPublisherById () throws Exception {
        // Arrange

        Publisher outputPublisher = new Publisher();
        outputPublisher.setPublisherId(121);
        outputPublisher.setName("Penguin Classics");
        outputPublisher.setStreet("Penguin Street");
        outputPublisher.setCity("Penguitopia");
        outputPublisher.setState("Club Penguin");
        outputPublisher.setPostalCode("12345");
        outputPublisher.setPhone("222-333-4444");
        outputPublisher.setEmail("pclassics@gmail.com");

        String outputJson = mapper.writeValueAsString(outputPublisher);
        mockMvc.perform(MockMvcRequestBuilders.get("/publishers/121")).andDo(print()).andExpect(status().isAccepted());
    }



    // Get all "/publishers"
    @Test
    public void shouldReturnAllPublishers () throws Exception {
        // Arrange

        Publisher outputPublisher = new Publisher();
        outputPublisher.setPublisherId(121);
        outputPublisher.setName("Penguin Classics");
        outputPublisher.setStreet("Penguin Street");
        outputPublisher.setCity("Penguitopia");
        outputPublisher.setState("Club Penguin");
        outputPublisher.setPostalCode("12345");
        outputPublisher.setPhone("222-333-4444");
        outputPublisher.setEmail("pclassics@gmail.com");

        String outputJson = mapper.writeValueAsString(outputPublisher);
        mockMvc.perform(MockMvcRequestBuilders.get("/publishers")).andDo(print()).andExpect(status().isAccepted());
    }

    // Put publisher "/publishers"
    @Test
    public void shouldUpdateOnePublisher () throws Exception {
        // Arrange

        Publisher inputPublisher = new Publisher();
        inputPublisher.setPublisherId(121);
        inputPublisher.setName("Penguin Classics");
        inputPublisher.setStreet("Penguin Street");
        inputPublisher.setCity("Penguitopia");
        inputPublisher.setState("Club Penguin");
        inputPublisher.setPostalCode("12345");
        inputPublisher.setPhone("222-333-4444");
        inputPublisher.setEmail("pclassics@gmail.com");

        String inputJson = mapper.writeValueAsString(inputPublisher);
        mockMvc.perform(MockMvcRequestBuilders.get("/publishers")).andDo(print()).andExpect(status().isAccepted());
    }

    // Delete publisher "/publishers/{id}"
    @Test
    public void shouldDeleteByIdAndReturn204StatusCode() throws Exception {
        mockMvc.perform(delete("/publishers/5"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}
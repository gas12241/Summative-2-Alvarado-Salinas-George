package com.company.bookstore.repository;

import com.company.bookstore.model.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepository;

    private Publisher newPublisher;

    @Before
    public void setUp() throws Exception {
        publisherRepository.deleteAll();
        newPublisher = new Publisher();
        newPublisher.setCity("Lego City");
        newPublisher.setState("LS");
        newPublisher.setEmail("breads@publisher.com");
        newPublisher.setName("Brick Reads");
        newPublisher.setPhone("2061880090");
        newPublisher.setStreet("Breads Ave");
        newPublisher.setPostalCode("98120");
        publisherRepository.save(newPublisher);
    }

    // Test Create publisher
    @Test
    public void shouldCreatePublisher() throws Exception{
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publisher");
        publisher.setStreet("Penguin Street");
        publisher.setCity("Penguin City");
        publisher.setState("Club Penguin");
        publisher.setPostalCode("00100");
        publisher.setPhone("202-010-0789");
        publisher.setEmail("penguinpublisher@gmail.com");

        publisherRepository.save(publisher);
        Optional<Publisher> publisherHolder = publisherRepository.findById(publisher.getPublisherId());
        assertEquals(publisher.getPublisherId(),publisherHolder.get().getPublisherId());
    }

    // Test Get By Id
    @Test
    public void shouldGetPublisherById() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publisher");
        publisher.setStreet("Penguin Street");
        publisher.setCity("Penguin City");
        publisher.setState("Club Penguin");
        publisher.setPostalCode("00100");
        publisher.setPhone("202-010-0789");
        publisher.setEmail("penguinpublisher@gmail.com");
        publisher = publisherRepository.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("New Books Publishing");
        publisher2.setStreet("New Street");
        publisher2.setCity("New York");
        publisher2.setState("New York State");
        publisher2.setPostalCode("89672");
        publisher2.setPhone("087-345-7459");
        publisher2.setEmail("nbpublishing@gmail.com");

        publisher2 = publisherRepository.save(publisher2);

        Optional<Publisher> foundPublisher = publisherRepository.findById(publisher.getPublisherId());
        assertEquals(foundPublisher.get(), publisher);
    }

    // Test Get All
    @Test
    public void shouldGetAllPublishers() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publisher");
        publisher.setStreet("Penguin Street");
        publisher.setCity("Penguin City");
        publisher.setState("Club Penguin");
        publisher.setPostalCode("00100");
        publisher.setPhone("202-010-0789");
        publisher.setEmail("penguinpublisher@gmail.com");
        publisher = publisherRepository.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("New Books Publishing");
        publisher2.setStreet("New Street");
        publisher2.setCity("New York");
        publisher2.setState("New York State");
        publisher2.setPostalCode("89672");
        publisher2.setPhone("087-345-7459");
        publisher2.setEmail("nbpublishing@gmail.com");
        publisher2 = publisherRepository.save(publisher2);

        List<Publisher> pList = publisherRepository.findAll();
        assertEquals(pList.size(), 2);
    }

    // Test Update Publisher
    @Test
    public void shouldUpdatePublisher() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publisher");
        publisher.setStreet("Penguin Street");
        publisher.setCity("Penguin City");
        publisher.setState("Club Penguin");
        publisher.setPostalCode("00100");
        publisher.setPhone("202-010-0789");
        publisher.setEmail("penguinpublisher@gmail.com");
        publisher = publisherRepository.save(publisher);

        publisher.setName("New Publisher");
        publisher.setStreet("New Street");
        publisher.setCity("New City");
        publisher.setState("New State");
        publisher.setPostalCode("56789");
        publisher.setPhone("123-098-4567");
        publisher.setEmail("npub@gmail.com");
        publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getPublisherId());
        assertEquals(publisher1.get(), publisher);
    }

    // Test Delete Publisher
    @Test
    public void shouldDeletePublisher() throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Penguin Publisher");
        publisher.setStreet("Penguin Street");
        publisher.setCity("Penguin City");
        publisher.setState("Club Penguin");
        publisher.setPostalCode("00100");
        publisher.setPhone("202-010-0789");
        publisher.setEmail("penguinpublisher@gmail.com");
        publisher = publisherRepository.save(publisher);

        Optional<Publisher> publisher1 = publisherRepository.findById(publisher.getPublisherId());

        assertEquals(publisher1.get(), publisher);

        publisherRepository.deleteById(publisher.getPublisherId());

        publisher1 = publisherRepository.findById(publisher.getPublisherId());

        assertFalse(publisher1.isPresent());
    }
}
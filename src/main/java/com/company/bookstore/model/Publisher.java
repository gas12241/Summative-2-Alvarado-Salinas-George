package com.company.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Publisher class that will be used in the Bookstore Application.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="publisher")
public class Publisher implements Serializable {

    /**
     * Instance variables for the Publisher Model.
     */
    @Id
    @Column(name="publisher_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int publisherId;
    private String name;
    private String street;
    private String city;
    // Can only be two characters, maybe why my tests don't work
    private String state;

    @Column(name = "postal_code")
    private String postalCode;
    private String phone;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<Book>();

    /**
     * Getter for the publisherId of the Publisher Object.
     * @return Returns an int, the publisherId of the Publisher Object.
     */
    public int getPublisherId() {
        return publisherId;
    }

    /**
     * Setter for the publisherId of the Publisher Object.
     * @param publisherId int that will be used to set the publisherId
     *                    of the Publisher Object.
     */
    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    /**
     * Getter for the name of the Publisher Object.
     * @return Returns a String, the name of the Publisher Object.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the Publisher Object.
     * @param name String that will be used to set the name
     *             of the Publisher Object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the street of the Publisher Object.
     * @return Returns a String, the street of the Publisher
     *         Object.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for the street of the Publisher Object.
     * @param street String that will be used to set the street
     *               of the Publisher Object.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for the city of the Publisher Object.
     * @return Returns a String, the city of the
     *         Publisher Object.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for the city of the Publisher Object.
     * @param city String that will be used to set the city
     *             of the Publisher Object.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for the state of the Publisher Object.
     * @return Returns a String, the state of
     *         the Publisher Object.
     */
    public String getState() {
        return state;
    }

    /**
     * Setter for the state of the Publisher Object.
     * @param state String that will be used to set the state
     *              of the Publisher Object.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter for the postalCode of the Publisher Object.
     * @return Returns a String, the postalCode of
     *         the Publisher Object.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Setter for the postalCode of the Publisher Object.
     * @param postalCode String that will be used to set the
     *                   postalCode of the Publisher Object.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Getter for the phone of the Publisher Object.
     * @return Returns a String, the phone of the Publisher object.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter for the phone of the Publisher Object.
     * @param phone String that will be used to set
     *              the phone of the Publisher Object.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter for the email of the Publisher Object.
     * @return Returns a String, the email of
     *         the Publisher Object.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the email of the Publisher Object.
     * @param email String that will be used to set the
     *              email of the Publisher Object.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for the books of the Publisher Object.
     * @return Returns a Set, the books of the Publisher Object.
     */
    public Set<Book> getBooks() {
        return books;
    }

    /**
     * Setter for the books of the Publisher Object.
     * @param books A Set that will be used to set the
     *              books of the Publisher Object.
     */
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    /**
     * equals() of the Publisher Object. Will be
     * used to test for equality.
     * @param o Object o that will be compared to the Publisher
     *          Object that is calling the method.
     * @return Returns true if the Objects being compared are
     *         equal to each other.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return getPublisherId() == publisher.getPublisherId() && Objects.equals(getName(), publisher.getName()) && Objects.equals(getStreet(), publisher.getStreet()) && Objects.equals(getCity(), publisher.getCity()) && Objects.equals(getState(), publisher.getState()) && Objects.equals(getPostalCode(), publisher.getPostalCode()) && Objects.equals(getPhone(), publisher.getPhone()) && Objects.equals(getEmail(), publisher.getEmail()) && Objects.equals(getBooks(), publisher.getBooks());
    }

    /**
     * hashCode() of the Publisher Object. Will be
     * used to test for equality.
     * @return Returns a hash of the Publisher Object calling it,
     *         specific to the instance variables.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getPublisherId(), getName(), getStreet(), getCity(), getState(), getPostalCode(), getPhone(), getEmail(), getBooks());
    }

    /**
     * toString() of the Publisher Object. Will be
     * used to test for equality.
     * @return Returns the object in String version,
     *         specific to the instance variables
     *         of the Publisher Object.
     */
    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", books=" + books +
                '}';
    }
}

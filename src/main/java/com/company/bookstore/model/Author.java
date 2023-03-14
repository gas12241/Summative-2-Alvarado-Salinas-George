package com.company.bookstore.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Author class that will be used as a Model in
 * the Bookstore Application.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="author")
public class Author implements Serializable {

    /**
     * Instance variables for the Author Model.
     */
    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String street;
    private String city;
    private String state;

    @Column(name = "postal_code")
    private String postalCode;
    private String phone;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private Set<Book> books = new HashSet<Book>();

    /**
     * Getter for the authorId of the Author Object.
     * @return Returns an int, the authorId of the Author
     *         Object.
     */
    public int getAuthorId() {
        return authorId;
    }

    /**
     * Setter for the authorId of the Author Object.
     * @param authorId int that will be used to set
     *                 the authorId of an Author Object.
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /**
     * Getter for the firstName of the Author Object.
     * @return Returns a String, the firstName of the
     *         Author Object.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the firstName of the Author Object.
     * @param firstName String that will be used to set
     *                  the firstName of the Author Object.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for the lastName of the Author Object.
     * @return Returns a String, the lastName
     *         of the Author Object.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the lastName of the Author Object.
     * @param lastName String that will be used to set
     *                 the lastName of the Author Object.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the street of the Author Object.
     * @return Returns a String, the street of the
     *         Author Object.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setter for the street of the Author Object.
     * @param street String that will be used to set
     *               the street of the Author Object.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Getter for the city of the Author Object.
     * @return Returns a String, the city of the
     *         Author Object.
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter for the city of the Author Object.
     * @param city String that will be used to set
     *             the city of the Author Object.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter for the state of the Author Object.
     * @return Returns a String, the state of the Author Object.
     */
    public String getState() {
        return state;
    }

    /**
     * Setter for the state of the Author Object.
     * @param state String that will be used to set
     *              the state of the Author Object.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Getter for the postalCode of the Author Object.
     * @return Returns a String, the postalCode
     *         of the Author Object.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Setter for the postalCode of the Author Object.
     * @param postalCode String that will be used to set
     *                   the postalCode of the Author Object.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Getter for the phone of the Author Object.
     * @return Returns a String, the phone of the Author Object.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter for the phone of the Author Object.
     * @param phone String that will be used to set the
     *              phone of the Author Object.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter for the email of the Author Object.
     * @return Returns a String, the email
     *         of the Author Object.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for the email of the Author Object.
     * @param email String that will be used to set the
     *              email of the Author Object.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for the books of the Author Object.
     * @return Returns a Set of Books, the
     *         books of the Author Object.
     */
    public Set<Book> getBooks() {
        return books;
    }

    /**
     * Setter for the books of the Author Object.
     * @param books Set that will be used to set
     *              the books of the Author Object.
     */
    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    /**
     * equals() for the Author Object.
     * @param o Object o that will be used to compare with.
     * @return Returns true if the object being used for comparison
     *         is equal to the object calling the method.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getAuthorId() == author.getAuthorId() && Objects.equals(getFirstName(), author.getFirstName()) && Objects.equals(getLastName(), author.getLastName()) && Objects.equals(getStreet(), author.getStreet()) && Objects.equals(getCity(), author.getCity()) && Objects.equals(getState(), author.getState()) && Objects.equals(getPostalCode(), author.getPostalCode()) && Objects.equals(getPhone(), author.getPhone()) && Objects.equals(getEmail(), author.getEmail()) && Objects.equals(getBooks(), author.getBooks());
    }

    /**
     * hashCode() for the Author Object.
     * @return Returns a hashed version of the Object,
     *         specific to its instance variables.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getAuthorId(), getFirstName(), getLastName(), getStreet(), getCity(), getState(), getPostalCode(), getPhone(), getEmail(), getBooks());
    }

    /**
     * toString() for the Author Object.
     * @return Returns a String version of the Object,
     *         specific to its instance variables.
     */
    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
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
package com.company.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * Book class that will be used in a Bookstore Application.
 * Model for an Object that will be gotten from the Database.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="book")
public class Book  implements Serializable {

    /**
     * Instance variables for a Book Model.
     */
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String isbn;

    @Column(name = "publish_date")
    private LocalDate publishDate;

    @Column(name = "author_id")
    private int authorId;
    private String title;

    @Column(name = "publisher_id")
    private int publisherId;
    private BigDecimal price;

    /**
     * Getter for the bookId of a Book Object.
     * @return Returns an int, the bookId
     *         of a Book Object.
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Setter for the bookId of a Book Object.
     * @param bookId int that will be used to set the
     *               bookId of the Book Object.
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * Getter for the isbn of a Book Object.
     * @return Returns a String, the isbn of
     *         the Book Object.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Setter for the isbn of a Book Object.
     * @param isbn String that will be used to set
     *             the isbn of the Book Object.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter for the publishDate of a Book Object.
     * @return Returns a LocalDate, the publishDate
     *         of the Book Object.
     */
    public LocalDate getPublishDate() {
        return publishDate;
    }

    /**
     * Setter for the publishDate of a Book Object.
     * @param publishDate LocalDate that will be used
     *                    to set the publishDate
     *                    of the Book Object.
     */
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    /**
     * Getter for the authorId of a Book Object.
     * @return Returns an int, the authorId of
     *         the Book Object.
     */
    public int getAuthorId() {
        return authorId;
    }

    /**
     * Setter for the authorId of a Book Object.
     * @param authorId int that will be used to set
     *                 the authorId of the Book Object.
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /**
     * Getter for the title of a Book Object.
     * @return Returns a String, the title
     *         of the Book Object.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for the title of a Book Object.
     * @param title String that will be used to
     *              set the title of the Book Object.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for the publisherId of the Book Object.
     * @return Returns an int, the publisherId of the
     *         Book Object.
     */
    public int getPublisherId() {
        return publisherId;
    }

    /**
     * Setter for the publisherId of a Book Object.
     * @param publisherId int that will be used to
     *                    set the publisherId of
     *                    the Book Object.
     */
    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    /**
     * Getter for the price of the Book Object.
     * @return Returns a BigDecimal, the price of the
     *         Book Object.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Setter for the price of the Book Object.
     * @param price BigDecimal that will be used
     *              to set the price of the Book
     *              Object.
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * equals() method for the Book Object. Will be used to test
     * for equality.
     * @param o Object o that will be used to test for equality.
     * @return Returns true if the objects that are being compared
     *         are equal to each other in their instance variables.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookId() == book.getBookId() && getAuthorId() == book.getAuthorId() && getPublisherId() == book.getPublisherId() && Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getPublishDate(), book.getPublishDate()) && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getPrice(), book.getPrice());
    }

    /**
     * hashCode() method for the Book Object. Will be used to test
     * for equality.
     * @return Returns a hash of the Book Object, specific to the
     *         instance variables.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getIsbn(), getPublishDate(), getAuthorId(), getTitle(), getPublisherId(), getPrice());
    }

    /**
     * toString() method for the Book Object. Will be used
     * to test for equality.
     * @return Returns a String version of the Book Object,
     *         specific to the instance variables.
     */
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", publisherId=" + publisherId +
                ", price=" + price +
                '}';
    }
}

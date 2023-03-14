package com.company.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the class that runs the Application.
 * Will start the Bookstore Application.
 */
@SpringBootApplication
public class BookstoreApplication {

	/**
	 * Main method of the Application.
	 * @param args Args of the main method.
	 */
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}

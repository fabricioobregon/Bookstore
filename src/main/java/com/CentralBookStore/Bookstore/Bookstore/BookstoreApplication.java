package com.CentralBookStore.Bookstore.Bookstore;

import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {

		SpringApplication.run(BookstoreApplication.class, args);

	}

}

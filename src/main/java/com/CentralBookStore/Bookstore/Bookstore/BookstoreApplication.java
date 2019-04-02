package com.CentralBookStore.Bookstore.Bookstore;

import com.CentralBookStore.Bookstore.Bookstore.Service.StoreManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);

		StoreManager storeManager = new StoreManager();
		storeManager.execute();

	}

}

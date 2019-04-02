package com.CentralBookStore.Bookstore.Bookstore;

import com.CentralBookStore.Bookstore.Bookstore.Service.StoreManager;

//@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		//SpringApplication.run(BookstoreApplication.class, args);

		StoreManager storeManager = new StoreManager();
		storeManager.execute();

	}

}

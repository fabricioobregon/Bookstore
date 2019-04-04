package com.CentralBookStore.Bookstore.Bookstore;

import com.CentralBookStore.Bookstore.Bookstore.Service.StoreManager;
import com.CentralBookStore.Bookstore.Bookstore.Utilities.ReadKeyboard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {

		//SpringApplication.run(BookstoreApplication.class, args);

		StoreManager storeManager;
		while (true){
			storeManager = new StoreManager(StoreManager.userModeSelected());
			String state = storeManager.execute();
			if( state == null) {
			} else if (state.equals("finished")){
			}
		}

	}

}

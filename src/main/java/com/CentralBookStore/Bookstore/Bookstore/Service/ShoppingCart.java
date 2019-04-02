package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Service
public class ShoppingCart {
    private BookRepository bookRepository;
    private final String checkOutMessage = "This is your order: ";
        private static int globalShoppingCartId = 0;
        private int id;
        private static List<Book> globalBooks = new ArrayList<Book>();
        private List<Book> cartBbooks = new ArrayList<Book>();

    public ShoppingCart(BookRepository bookRepository) {
        this.bookRepository = this.bookRepository;
    }

    private int generateId() {
        this.id = globalShoppingCartId;
        globalShoppingCartId++;
        return id;
    }



    public void checkOut(){
        System.out.println(checkOutMessage);

    }


    public void cartOperations() {
    }
}

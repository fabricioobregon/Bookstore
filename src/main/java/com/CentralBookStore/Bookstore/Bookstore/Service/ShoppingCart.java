package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private int id;
    private static int globalShoppingCartId = 0;
    private UserMode userMode;
    private BookRepository bookRepository;
    //private static List<Book> globalBooks = new ArrayList<Book>();
    //private List<Book> cartBbooks = new ArrayList<Book>();

    public ShoppingCart(UserMode userMode, BookRepository repository, Scanner scanner) {
        this.userMode = userMode;
        this.bookRepository = this.bookRepository;
    }

    private int generateId() {
        this.id = globalShoppingCartId;
        globalShoppingCartId++;
        return id;
    }

    public void checkOut(){

    }

    public void cartOperations() {

    }

    public void execute() {
    }
}

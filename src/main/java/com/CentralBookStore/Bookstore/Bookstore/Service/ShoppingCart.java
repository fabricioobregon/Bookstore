package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Utilities.ReadKeyboard;

public class ShoppingCart {
    private int id;
    private static int globalShoppingCartId = 0;
    private UserMode userMode;
    private BookRepository bookRepository;
    //private static List<Book> globalBooks = new ArrayList<Book>();
    //private List<Book> cartBbooks = new ArrayList<Book>();

    public ShoppingCart(UserMode userMode, BookRepository bookRepository) {
        this.userMode = userMode;
        this.bookRepository = bookRepository;
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

    public void execute(){
        if(userMode == userMode.ADMIN){
            cartOperations();
        } else {
            System.out.println("You do not have access logged as " + this.userMode);
        }
    }
}

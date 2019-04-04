package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;

public class ShoppingCart {
    private int id;
    private static int globalShoppingCartId = 0;
    private UserMode userMode;
    private BookRepository bookRepository;
    private static final String SHOPPINGCARTOPTIONMENU = "Please, selec the option from menu: \n" +
            "1 - To add a book to the cart\n" +
            "2 - To remove a book from the cart\n" +
            "3 - To checkout\n" +
            "4 - to return to previous menu";

    public ShoppingCart(UserMode userMode, BookRepository bookRepository) {
        this.userMode = userMode;
        this.bookRepository = bookRepository;
    }

    private int generateCartId() {
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
            generateCartId();
            cartOperations();
        } else {
            System.out.println("You do not have access logged as " + this.userMode);
        }
    }
}

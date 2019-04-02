package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
        private final String checkOutMessage = "This is your order: ";
        private static int globalShoppingCartId = 0;
        private int id;
        private static List<Book> globalBooks = new ArrayList<Book>();
        private List<Book> cartBbooks = new ArrayList<Book>();

    public ShoppingCart(Enum USERMODE) {
        if(!USERMODE.equals(UserMode.VISITOR)){
            this.id = generateId();
            System.out.println("This ShoppingCart Id " + this.id);
        }
            System.out.println("You do not have permission to start a Shopping Cart!");
    }

    private int generateId() {
        this.id = globalShoppingCartId;
        globalShoppingCartId++;
        return id;
    }



    public void checkOut(){
        System.out.println(checkOutMessage);

    }



}

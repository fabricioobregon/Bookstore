package com.CentralBookStore.Bookstore.Bookstore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
        private final String checkOutMessage = "This is your order: ";
        private static int globalShoppingCartId = 0;
        private int id;
        private static List<Book> globalBooks = new ArrayList<Book>();
        private List<Book> cartBbooks = new ArrayList<Book>();

    public ShoppingCart(Enum USERMODE) {
        this.id = generateId();
        System.out.println("This ShoppingCart Id " + this.id);
    }

    private int generateId() {
        this.id = globalShoppingCartId;
        globalShoppingCartId++;
        return id;
    }

    public void addBookstoStore(){
        Book book = new Book("Harry Potter 1");
        globalBooks.add(book);
        book = new Book("Harry Potter 2");
        globalBooks.add(book);
        book = new Book("Harry Potter 3");
        globalBooks.add(book);
        book = new Book("Harry Potter 4");
        globalBooks.add(book);
        book = new Book("Harry Potter 5");
        globalBooks.add(book);
    }

    public void addBookstoCart(List<Book> books){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a book do add to your Shopping Cart");
        Iterator iterator = books.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.toString());
        }


        //this.cartBbooks.add(book);
    }

    public void checkOut(){
        System.out.println(checkOutMessage);

    }



}

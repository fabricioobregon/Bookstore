package com.CentralBookStore.Bookstore.Bookstore.Model;

public class Book {
    private static int globalID = 0;
    private final String id;
    private final String title;

    public Book(String title){
        this.id = String.valueOf(globalID);
        this.title = title;
        globalID++;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String toString(){

       return "Book Id: " + this.id + " Title: " + this.title;

    }
}

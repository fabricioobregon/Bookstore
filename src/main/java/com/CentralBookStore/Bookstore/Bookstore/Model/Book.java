package com.CentralBookStore.Bookstore.Bookstore.Model;

public class Book {
    private static int globalBookId = 0;
    private int id;
    private String title;

    public Book(String title){
        this.id = generateId();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int generateId() {
        this.id = globalBookId;
        globalBookId++;
        return id;
    }

    public String toString(){

       return "Book Id: " + this.id + "Book title: " + this.title;

    }
}

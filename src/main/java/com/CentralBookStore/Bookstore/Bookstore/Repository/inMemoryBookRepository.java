package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class inMemoryBookRepository implements BookRepository{
    private final List<Book> books = new ArrayList<>();

    public boolean isEmpty(){
        if (books.isEmpty()){
            System.out.println("There are no books!");
            return true;
        }
        return false;
    }

    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        System.out.println("There is no book with id: " + id);
        return null;
    }

    @Override
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        System.out.println("There is no book with title: " + title);
        return null;
    }

    @Override
    public void delete(String id) {
        if(findById(id) == null) {
        System.out.println("There is no book with id: " + id);
            return;
        }
        books.remove(findById(id));
    }

    @Override
    public void clear() {
        books.clear();
    }
}

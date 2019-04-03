package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class inMemoryBookRepository implements BookRepository{
    private final List<Book> books = new ArrayList<>();


    @Override
    public void save(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public List<Book> findByName(String name) {
        return null;
    }

    @Override
    public Book findById(int id) {
        Book book = books.get(id);
        return book;
    }

    @Override
    public void delete(int id) {
        books.remove(id);
    }
}

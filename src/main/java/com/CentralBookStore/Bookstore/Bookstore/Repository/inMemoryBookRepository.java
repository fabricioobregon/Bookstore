package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
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
    public List<Book> findById(int id) {
        return null;
    }
}

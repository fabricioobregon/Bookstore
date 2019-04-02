package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    List<Book> findByName(String name);

    List<Book> findById(int id);
}

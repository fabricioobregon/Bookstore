package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;

import java.util.List;

public interface BookRepository {

    boolean isEmpty();

    void save(Book book);

    List<Book> findAll();

    Book findById(String id);

    Book findByTitle(String title);

    void delete (String id);

    void clear();
}

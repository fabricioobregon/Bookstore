package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    List<Book> findAll();

    List<Book> findByName(String name);

    Book findById(int id);

    void delete (int id);

}

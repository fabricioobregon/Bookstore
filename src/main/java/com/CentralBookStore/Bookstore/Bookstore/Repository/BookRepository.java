package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;

public interface BookRepository {

    boolean checkEmpty();

    void save(Book book);

    void findAll();

    Book findById(String id);

    Book findByTitle(String title);

    void delete (String id);
}

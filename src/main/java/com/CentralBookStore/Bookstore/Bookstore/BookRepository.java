package com.CentralBookStore.Bookstore.Bookstore;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    List<Book> findByName(String name);

    List<Book> findById(int id);
}

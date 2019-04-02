package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public interface BookRepository {

    void save(Book book);

    List<Book> findAll();

    List<Book> findByName(String name);

    List<Book> findById(int id);
}

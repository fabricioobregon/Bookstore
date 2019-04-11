package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public BookService() {
    }

    //
    public List<Book> addBook(Book book){
        bookRepository.save(book);
        return bookRepository.findAll();
    }

    public List<Book> find(){
        return bookRepository.findAll();
    }


}

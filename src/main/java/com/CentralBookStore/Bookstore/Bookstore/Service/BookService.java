package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Repository.AuthorRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
     private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public BookService() {
    }

    @Transactional
    public Book addBook(Book book){
        book.setAuthors(book.getAuthors().stream()
                .map(author -> (authorRepository.findByName(author.getName()) != null) ? authorRepository.findByName(author.getName()) : author)
                .collect(Collectors.toList()));
        bookRepository.save(book);
        return book;
    }

    public List<Book> find(){
        return bookRepository.findAll();
    }

}

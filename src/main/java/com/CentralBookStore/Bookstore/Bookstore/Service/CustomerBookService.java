package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Repository.AuthorRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.CustomerBookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerBookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private CustomerRepository customerRepository;
    private CustomerBookRepository customerBookRepository;

    @Autowired
    public CustomerBookService(BookRepository bookRepository, AuthorRepository authorRepository,
                               CustomerRepository customerRepository, CustomerBookRepository customerBookRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.customerRepository = customerRepository;
        this.customerBookRepository = customerBookRepository;
    }

}

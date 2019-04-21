package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
import com.CentralBookStore.Bookstore.Bookstore.Repository.AuthorRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.CustomerBookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private CustomerRepository customerRepository;
    private CustomerBookRepository customerBookRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
                        CustomerRepository customerRepository, CustomerBookRepository customerBookRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.customerRepository = customerRepository;
        this.customerBookRepository = customerBookRepository;
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

    public List<Customer> findCustomers(){ return customerRepository.findAll(); }

    public List<CustomerBook> findCustomerBooks(){return customerBookRepository.findAll(); }


}

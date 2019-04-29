package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Repository.AuthorRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {
    private static BookRepository bookRepository;
    private static AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Transactional
    public Book addBook(Book book){ //post
        book.setAuthors(book.getAuthors().stream()//check if author already exists and replace
                .map(author -> (authorRepository.findByName(author.getName()) != null) ? authorRepository.findByName(author.getName()) : author)
                .collect(Collectors.toSet()));
            bookRepository.save(book);
        return book;
    }
    public List<Book> findAllBooks(){ //get
        return bookRepository.findAll();
    }

    public List<Book> findAllBooksByUser(UUID uuid){ //get
        return bookRepository.findAllByCustomerId(uuid);
    }

    public Book findById(Long id){return bookRepository.findBookById(id);}

    public Set<Book> findBooks(String string){ //get
        Set<Book> bookList = new HashSet<>();
        bookList.addAll(bookRepository.findUserBookByAuthorsIsLike(string));
        bookList.addAll(bookRepository.findUserBookByIsbn(string));
        bookList.addAll(bookRepository.findUserBookByTitleIsLike(string));
      return bookList;
    }

    @Transactional
    public void deleteBook(Long id){ //delete
         Book book = bookRepository.findBookById(id);
         //book.getAuthors().removeAll(book.getAuthors()); //  << Three days suffering here
         bookRepository.delete(book);

    }

    @Transactional
    //need to guarantee that every field will have a value loading in the frontend form
    public Book updateBook(Book book){ //post
        Book bookUpdate = new Book();
        bookUpdate = bookRepository.getOne(book.getId());
        bookUpdate.setTitle(book.getTitle());
        bookUpdate.setIsbn(book.getIsbn());
        bookUpdate.setYear(book.getYear());
        bookUpdate.setImageUrl(book.getImageUrl());
        bookUpdate.setCategory(book.getCategory());
        bookUpdate.setDescription(book.getDescription());
        bookUpdate.setAuthors(book.getAuthors());
        bookRepository.save(bookUpdate);
        return bookUpdate;
    }


}

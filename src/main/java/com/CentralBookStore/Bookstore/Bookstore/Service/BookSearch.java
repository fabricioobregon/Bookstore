package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class BookSearch {
    private UserMode userMode;
    private BookRepository bookRepository;
    private static final String BOOKSEARCHOPTIONMENU = "Please, selec the option from menu: \n" +
                       "1 - To search by ID\n" +
                       "2 - To search by Title\n" +
                       "3 - To list all the books\n" +
                       "4 - to EXIT";

    public BookSearch(UserMode userMode, BookRepository bookRepository) {
        this.userMode = userMode;
        this.bookRepository = bookRepository;
    }

    public void execute(){

        searchOperations();

    }

    private void searchOperations() {
    }


    public void listBooks(){
        List<Book> books;
        books = bookRepository.findAll();
        String collect = books.stream().map(Book::toString).collect(Collectors.joining("\n"));
        System.out.println(collect);
    }
}




package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;

import java.util.Scanner;

public class BookSearch {
    Scanner scanner = new Scanner(System.in);
    private static final String BOOKSEARCHOPTIONMENU = "Please, selec the option from menu: \n" +
                       "1 - To search by ID\n" +
                       "2 - To search by Title\n" +
                       "3 - To list all the books\n" +
                       "4 - to EXIT";

    public BookSearch(UserMode userMode, BookRepository bookRepository, Scanner scanner) {
        System.out.println("Find your Books");
    }

    public void execute() {
    }
}




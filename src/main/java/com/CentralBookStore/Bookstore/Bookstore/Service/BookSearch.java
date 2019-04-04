package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Utilities.ReadKeyboard;

import java.util.List;
import java.util.stream.Collectors;

public class BookSearch {
    private static BookRepository bookRepository;
    private static final String BOOKSEARCHOPTIONMENU = "Please, selec the option from menu: \n" +
                       "1 - To list all the books\n" +
                       "2 - To search by ID\n" +
                       "3 - To search by Title\n" +
                       "4 - to EXIT";

    public BookSearch(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void execute(){
        searchOperations();
    }

    private static void searchOperations() {
        boolean loop = true;
        do{
            switch (ReadKeyboard.numberUsingMenu(BOOKSEARCHOPTIONMENU,4)) {
                case 1:
                    findAll();
                    break;
                case 2:
                    findById();
                    break;
                case 3:
                    findByTitle();
                    break;
                case 4:
                    loop = false;
                    break;
            }
        }while(loop);
    }

    public static List<Book> findAll(){
        if(bookRepository.isEmpty()){
            return null;
        }
        List <Book> books = bookRepository.findAll();
        String collect = books.stream().map(Book::toString).collect(Collectors.joining("\n"));
        System.out.println(collect);
        return books;
    }

    public static Book findById(){
        if(bookRepository.isEmpty()){
            return null;
        }
        String id = ReadKeyboard.text("Type the id to find the book");
        Book foundBook = bookRepository.findById(id);
        System.out.println(foundBook);
        return foundBook;

    }

    public static Book findByTitle(){
        if(bookRepository.isEmpty()){
            return null;
        }
        String title = ReadKeyboard.text("Type the title to find the book");
        Book foundBook = bookRepository.findByTitle(title);
        System.out.println(foundBook);
        return foundBook;
    }
}




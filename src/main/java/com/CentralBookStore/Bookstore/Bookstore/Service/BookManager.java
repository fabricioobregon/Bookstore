package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.BookManagerOptionMenu;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookManager {
    private final UserMode userMode;
    private BookRepository bookRepository;
    private final Scanner scanner;
    private ReadKeyboard readKeyboard ;
    private static final String BOOKMANAGEROPTIONMENU = "Please, selec the option from menu: \n" +
            "1 - For " + BookManagerOptionMenu.ADDBOOK + "\n" +
            "2 - For " + BookManagerOptionMenu.LISTBOOKS + "\n" +
            "3 - For " + BookManagerOptionMenu.REMOVEBOOK + "\n" +
            "4 - For " + BookManagerOptionMenu.EXIT;

    public BookManager(UserMode userMode, BookRepository bookRepository, Scanner scanner) {
        this.userMode = userMode;
        this.bookRepository = bookRepository;
        this.scanner = scanner;
        this.readKeyboard = new ReadKeyboard(scanner,"", 0);

    }

    public void execute(){
        if(userMode == userMode.ADMIN){
            bookOperations();
        } else {
            System.out.println("You do not have access logged as " + this.userMode);
        }
    }

    public void bookOperations() {
    boolean loop = true;
        do{
            switch (readKeyboard.numberUsingMenu(scanner,BOOKMANAGEROPTIONMENU,4)) {
                case 1:
                    addBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    loop = false;
                    break;
            }
        }while(loop);
    }

    public void addBook(){
        Book book;
        book = new Book(readKeyboard.text(scanner,"Please, type the book title:"));
        System.out.println(book.toString());
        bookRepository.save(book);
    }

    public void listBooks(){
        List <Book> books;
        books = bookRepository.findAll();
        String collect = books.stream().map(Book::toString).collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    public void deleteBook(){
        listBooks();
        int id = Integer.valueOf(readKeyboard.text(scanner,"Type the id to delete the book"));
        bookRepository.delete(id);
    }
}

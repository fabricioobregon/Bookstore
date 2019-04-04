package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.BookManagerOptionMenu;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Utilities.ReadKeyboard;

public class BookManager {
    private UserMode userMode;
    private BookRepository bookRepository;
    private static final String BOOKMANAGEROPTIONMENU = "Please, selec the option from menu: \n" +
            "1 - For " + BookManagerOptionMenu.ADDBOOK + "\n" +
            "2 - For " + BookManagerOptionMenu.LISTBOOKS + "\n" +
            "3 - For " + BookManagerOptionMenu.REMOVEBOOK + "\n" +
            "4 - For " + BookManagerOptionMenu.EXIT;

    public BookManager(UserMode userMode, BookRepository bookRepository) {
        this.userMode = userMode;
        this.bookRepository = bookRepository;
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
            switch (ReadKeyboard.numberUsingMenu(BOOKMANAGEROPTIONMENU,4)) {
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
        book = new Book(ReadKeyboard.text("Please, type the book title:"));
        System.out.println(book.toString());
        bookRepository.save(book);
    }

    public void listBooks(){
        bookRepository.findAll();

    }

    public void deleteBook(){
        if(bookRepository.checkEmpty()){
            return;
        }
        String id = ReadKeyboard.text("Type the id to delete the book");
        bookRepository.delete(id);
    }
}

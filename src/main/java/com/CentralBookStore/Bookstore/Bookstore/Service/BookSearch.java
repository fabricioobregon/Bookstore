package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Utilities.ReadKeyboard;

public class BookSearch {
    private BookRepository bookRepository;
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

    private void searchOperations() {
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

    public void findAll(){
        bookRepository.findAll();

    }

    public void findById(){
        if(bookRepository.checkEmpty()){
            return;
        }
        String id = ReadKeyboard.text("Type the id to find the book");
        bookRepository.findById(id);

    }

    public void findByTitle(){
        if(bookRepository.checkEmpty()){
            return;
        }
        String title = ReadKeyboard.text("Type the title to find the book");
        bookRepository.findByTitle(title);
    }
}




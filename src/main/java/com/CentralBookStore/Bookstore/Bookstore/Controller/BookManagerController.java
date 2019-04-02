package com.CentralBookStore.Bookstore.Bookstore.Controller;

import com.CentralBookStore.Bookstore.Bookstore.Service.BookManager;
import org.springframework.stereotype.Controller;

@Controller
public class BookManagerController {
    private BookManager bookManager;

    public BookManagerController(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    public void addBook(){
        bookManager.addBook();
    }



}

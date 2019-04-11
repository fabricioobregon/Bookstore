package com.CentralBookStore.Bookstore.Bookstore.Controller;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class formController {
    @Autowired
    private BookService bookService;

    public formController() {
    }

    @PostMapping("/book")
    @ResponseBody
    public List<Book> addBook(@RequestParam(name="title") String title) {
        Book book = new Book();
        book.setTitle(title);
        bookService.addBook(book);
        return bookService.find();
    }


}
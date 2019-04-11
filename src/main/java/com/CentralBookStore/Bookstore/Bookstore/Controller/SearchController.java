package com.CentralBookStore.Bookstore.Bookstore.Controller;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Service.AuthorService;
import com.CentralBookStore.Bookstore.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    public SearchController() {
    }

    @GetMapping("/book")
    @ResponseBody
    public List<Book> findBook() {
        return bookService.find();
    }

    @GetMapping("/author")
    @ResponseBody
    public List<Author> findAuthor() {
        return authorService.find();
    }

}
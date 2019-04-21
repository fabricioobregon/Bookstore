package com.CentralBookStore.Bookstore.Bookstore.Controller;

import com.CentralBookStore.Bookstore.Bookstore.DTO.BookResponseDTO;
import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
import com.CentralBookStore.Bookstore.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OutputController {
    private BookService bookService;

    @Autowired
    public OutputController(BookService bookService) {
    this.bookService = bookService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/book")
    @ResponseBody
    public ResponseEntity<List<BookResponseDTO>> findAll() {
        return new ResponseEntity<>(BookResponseDTO.translateToDTO(bookService.find()), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/customers")
    @ResponseBody
    public List<Customer> findAllCustomers() {
        return bookService.findCustomers();
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/customerbooks")
    @ResponseBody
    public List<CustomerBook> findAllCustomerBookss() {
        return bookService.findCustomerBooks();
    }
}
package com.CentralBookStore.Bookstore.Bookstore.Controller;

import com.CentralBookStore.Bookstore.Bookstore.DTO.BookDTO;
import com.CentralBookStore.Bookstore.Bookstore.DTO.BookResponseDTO;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class InputController {
    @Autowired
    private BookService bookService;

    public InputController() {
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/book")
    public ResponseEntity<BookResponseDTO> save(@RequestBody @Valid BookDTO bookdto) {
        Book book = bookService.addBook(bookdto.translateToObject());
        return new ResponseEntity<>(BookResponseDTO.translateToDTO(book), HttpStatus.CREATED);
    }

}
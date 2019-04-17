package com.CentralBookStore.Bookstore.Bookstore.Controller;

import com.CentralBookStore.Bookstore.Bookstore.DTO.BookResponseDTO;
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
    @Autowired
    private BookService bookService;

    public OutputController() {
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/book")
    @ResponseBody
    public ResponseEntity<List<BookResponseDTO>> findAll() {
        return new ResponseEntity<>(BookResponseDTO.translateToDTO(bookService.find()), HttpStatus.CREATED);
    }

}
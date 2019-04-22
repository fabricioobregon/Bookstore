package com.CentralBookStore.Bookstore.Bookstore.Controller;

import com.CentralBookStore.Bookstore.Bookstore.DTO.BookDTO;
import com.CentralBookStore.Bookstore.Bookstore.DTO.BookResponseDTO;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
    this.bookService = bookService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public ResponseEntity<BookResponseDTO> addBook(@RequestBody @Valid BookDTO bookdto) {
        Book book = bookService.addBook(bookdto.translateToObject());
        return new ResponseEntity<>(BookResponseDTO.translateToDTO(book), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody @Valid Book book) {
        bookService.updateBook(book);
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findall")
    @ResponseBody
    public ResponseEntity<List<BookResponseDTO>> findAllBook() {
        return new ResponseEntity<>(BookResponseDTO.translateToDTO(bookService.findAllBooks()), HttpStatus.OK);
    }



}
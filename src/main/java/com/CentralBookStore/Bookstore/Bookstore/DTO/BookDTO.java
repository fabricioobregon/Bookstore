package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import lombok.Getter;

import java.util.List;

@Getter
public class BookDTO {
    private String title;
    private String description;
    private String imageUrl;
    private String isbn;
    private String edition;
    private String year;
    private List<Author> authors;

    public Book translateToObject(){
        return new Book(title, description, imageUrl, isbn, edition, year, authors);
    }

}


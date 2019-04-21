package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;
import java.util.List;

@Getter
public class BookDTO {
    @NotBlank(message = "{title.not.blank}")
    private String title;
    private String description;
    private String imageUrl;
    @NotNull(message = "{isbn.not.null}")
    @NotBlank(message = "{isbn.not.blank}")
   // @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$", message ="{isbn.not.valid}")
    private String isbn;
    private String edition;
    private String year;
    private List<Author> authors;

    public Book translateToObject(){
        return new Book(title, description, imageUrl, isbn, edition, year, authors);
    }

}


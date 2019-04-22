package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;
import java.util.Set;

@Getter
public class BookDTO {
    @ApiModelProperty(position = 0)
    @NotBlank(message = "{title.not.blank}")
    private String title;
    @ApiModelProperty(position = 1)
    private String description;
    @ApiModelProperty(position = 2)
    private String imageUrl;
    @ApiModelProperty(position = 3)
    @NotNull(message = "{isbn.not.null}")
    @NotBlank(message = "{isbn.not.blank}")
   // @Pattern(regexp = "^(97(8|9))?\\d{9}(\\d|X)$", message ="{isbn.not.valid}")
    private String isbn;
    @ApiModelProperty(position = 4)
    private String edition;
    @ApiModelProperty(position = 5)
    private String year;
    @ApiModelProperty(position = 6)
    private Set<Author> authors;

    public Book translateToObject(){
        return new Book(title, description, imageUrl, isbn, edition, year, authors);
    }

}


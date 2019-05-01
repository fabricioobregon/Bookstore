package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Service.CustomerService;
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
    private String category;
    @ApiModelProperty(position = 5)
    private String publisher;
    @ApiModelProperty(position = 6)
    private String year;
    @ApiModelProperty(position = 8)
    private String pageCount;
    @ApiModelProperty(position = 9)
    private String lastPage;
    @ApiModelProperty(position = 10)
    private Set<Author> authors;
    @ApiModelProperty(position = 11)
    private String customer_id;

//    Acts like this.
    public Book translateToBook(){
        return new Book(title, description, imageUrl, isbn, category, publisher, year,pageCount, lastPage, authors, CustomerService.translateToCustomer(customer_id));
    }




}


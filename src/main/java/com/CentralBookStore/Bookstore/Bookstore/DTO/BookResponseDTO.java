package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BookResponseDTO {
    @ApiModelProperty(position = 0)
    private Long id;
    @ApiModelProperty(position = 1)
    private String title;
    @ApiModelProperty(position = 2)
    private String description;
    @ApiModelProperty(position = 3)
    private String imageUrl;
    @ApiModelProperty(position = 4)
    private String isbn;
    @ApiModelProperty(position = 5)
    private String category;
    @ApiModelProperty(position = 6)
    private String publisher;
    @ApiModelProperty(position = 6)
    private String year;
    @ApiModelProperty(position = 7)
    private String pageCount;
    @ApiModelProperty(position = 8)
    private Set<Author> authors;
//    @ApiModelProperty(position = 8)
//    private Customer customer;

    public static BookResponseDTO translateToDTO(Book book) {
        return new BookResponseDTO(book.getId(),book.getTitle(),book.getDescription(), book.getImageUrl(),
                book.getIsbn(), book.getCategory(),book.getPublisher(), book.getYear(),book.getPageCount(), book.getAuthors());
    }

    public static List<BookResponseDTO> translateToDTO(List<Book> books) {
        List<BookResponseDTO> bookResponseDTOList = new ArrayList<>();
        for (Book book: books) {
            bookResponseDTOList.add(new BookResponseDTO(book.getId(),book.getTitle(),book.getDescription(), book.getImageUrl(),
                    book.getIsbn(), book.getCategory(),book.getPublisher(), book.getYear(),book.getPageCount()  , book.getAuthors()));
        }
        return bookResponseDTOList;
    }

}
package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
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
    private String edition;
    @ApiModelProperty(position = 6)
    private String year;
    @ApiModelProperty(position = 7)
    private Set<Author> authors;

    public static BookResponseDTO translateToDTO(Book book) {
        return new BookResponseDTO(book.getId(),book.getTitle(),book.getDescription(), book.getImageUrl(),
                book.getIsbn(), book.getEdition(), book.getYear(), book.getAuthors());
    }

    public static List<BookResponseDTO> translateToDTO(List<Book> books) {
        List<BookResponseDTO> bookResponseDTOList = new ArrayList<>();
        for (Book book: books) {
            bookResponseDTOList.add(new BookResponseDTO(book.getId(),book.getTitle(),book.getDescription(), book.getImageUrl(),
                book.getIsbn(), book.getEdition(), book.getYear(), book.getAuthors()));
        }
        return bookResponseDTOList;
    }

}
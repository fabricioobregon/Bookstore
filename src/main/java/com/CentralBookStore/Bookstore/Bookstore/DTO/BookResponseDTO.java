package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BookResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String isbn;
    private String edition;
    private String year;
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
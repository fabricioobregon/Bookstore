package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CustomerBookResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String isbn;
    private String edition;
    private String year;
    private Set<Author> authors;
    private int lastPage;
    private Date lastTimeModified;
    private Customer customer;
    private Date startTime;


    public static CustomerBookResponseDTO translateToDTO(CustomerBook customerBook) {
        return new CustomerBookResponseDTO(customerBook.getId(),customerBook.getTitle(),customerBook.getDescription(),
                customerBook.getImageUrl(), customerBook.getIsbn(), customerBook.getEdition(), customerBook.getYear(),
                customerBook.getAuthors(), customerBook.getLastPage(), customerBook.getLastTimeModified(),
                customerBook.getCustomer(), customerBook.getStartTime());
    }

    public static List<CustomerBookResponseDTO> translateToDTO(List<CustomerBook> customerBooks) {
        List<CustomerBookResponseDTO> customerBookResponseDTOList = new ArrayList<>();
        for (CustomerBook customerBook: customerBooks) {
            customerBookResponseDTOList.add(new CustomerBookResponseDTO(customerBook.getId(),customerBook.getTitle(),
                customerBook.getDescription(), customerBook.getImageUrl(), customerBook.getIsbn(), customerBook.getEdition(),
                customerBook.getYear(), customerBook.getAuthors(), customerBook.getLastPage(), customerBook.getLastTimeModified(),
                customerBook.getCustomer(), customerBook.getStartTime()));
        }
        return customerBookResponseDTOList;
    }
}

package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
import com.CentralBookStore.Bookstore.Bookstore.Repository.AuthorRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class CustomerBookDTO {
    private String title;
    private String description;
    private String imageUrl;
    private String isbn;
    private String edition;
    private String year;
    private Set<Author> authors;
    private int lastPage;
    private Customer customer;

    public CustomerBook translateToModel(){
        return new CustomerBook(title, description, imageUrl, isbn, edition, year, authors,lastPage, customer);
    }


//    public CustomerBook checkBook(CustomerBook customerBook){
//        customerBook.setAuthors(customerBook.getAuthors().stream()//check if author already exists and replace
//                .map(author -> (authorRepository.findByName(author.getName()) != null) ? authorRepository.findByName(author.getName()) : author)
//                .collect(Collectors.toSet()));
//        return customerBook;
//    }
//
//    public Set<CustomerBook> checkBooks(Set<CustomerBook> customerBooks){
//        Set<CustomerBook> newCustomerBook = new HashSet<>();
//        for (CustomerBook customerbook:customerBooks) {
//            newCustomerBook.add(checkBook(customerbook));
//        }
//        return newCustomerBook;
//    }



}

package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
//import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerDTOBook;
import lombok.Getter;

import java.util.Set;

@Getter
public class CustomerDTO {
    private String name;
    private String email;
    private String password;

    public Customer translateToObject(){
        return new Customer(name, email, password);
    }

}


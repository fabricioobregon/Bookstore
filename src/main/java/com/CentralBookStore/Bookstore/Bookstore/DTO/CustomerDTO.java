package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
import lombok.Getter;

import java.util.Set;

@Getter
public class CustomerDTO {
    private String name;
    private String email;
    private String password;
    private Set<CustomerBook> customerBooks;

    public Customer translateToObject(){
        return new Customer(name, email, password);
    }

}


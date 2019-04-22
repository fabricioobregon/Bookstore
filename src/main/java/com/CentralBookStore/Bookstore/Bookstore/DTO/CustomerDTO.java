package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
public class CustomerDTO {
    private String name;
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "email.not.valid")
    private String email;
    private String password;
    private Set<CustomerBook> customerBooks;

    public Customer translateToObject(){
        return new Customer(name, email, password);
    }

}


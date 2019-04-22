package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CustomerDTO {
    @ApiModelProperty(position = 0)
    private String name;
    @ApiModelProperty(position = 1)
    @NotBlank(message = "{email.not.blank}")
    //@Email(message = "email.not.valid")
    private String email;
    @ApiModelProperty(position = 2)
    private String password;
    //private Set<CustomerBook> customerBooks;

    public Customer translateToObject(){
        return new Customer(name, email, password);
    }

}


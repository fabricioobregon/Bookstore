package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
//import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Getter
public class CustomerResponseDTO {
    @ApiModelProperty(position = 0)
    private UUID id;
    @ApiModelProperty(position = 1)
    private String name;
    @ApiModelProperty(position = 2)
    private String email;
    @ApiModelProperty(position = 3)
    private String password;

    public CustomerResponseDTO(UUID id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public static CustomerResponseDTO translateToDTO(Customer customer) {
        return new CustomerResponseDTO(customer.getId(), customer.getName(),customer.getEmail(), customer.getPassword());
    }

    public static List<CustomerResponseDTO> translateToDTO(List<Customer> customers) {
        List<CustomerResponseDTO>  customeResponseDTOList = new ArrayList<>();
        for (Customer customer: customers) {
            customeResponseDTOList.add(new CustomerResponseDTO(customer.getId(), customer.getName(),customer.getEmail(), customer.getPassword()));
            }
        return customeResponseDTOList;
    }


}
package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
//    private Set<CustomerBook> customerBooks;


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
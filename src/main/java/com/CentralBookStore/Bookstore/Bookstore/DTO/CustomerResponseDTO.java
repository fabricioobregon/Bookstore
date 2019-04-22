package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CustomerResponseDTO {
    private UUID id;
    private String name;
    private String email;
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
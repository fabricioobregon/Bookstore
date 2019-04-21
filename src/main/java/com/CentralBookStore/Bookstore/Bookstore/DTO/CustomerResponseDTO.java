package com.CentralBookStore.Bookstore.Bookstore.DTO;

import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class CustomerResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<CustomerBook> customerBooks;


    public static CustomerResponseDTO translateToDTO(Customer customer) {
        return new CustomerResponseDTO(customer.getId(), customer.getName(),customer.getEmail(), customer.getPassword(), customer.getCustomerBooks());
    }

    public static List<CustomerResponseDTO> translateToDTO(List<Customer> customers) {
        List<CustomerResponseDTO>  customeResponseDTOList = new ArrayList<>();
        for (Customer customer: customers) {
            customeResponseDTOList.add(new CustomerResponseDTO(customer.getId(), customer.getName(),customer.getEmail(), customer.getPassword(), customer.getCustomerBooks()));
            }
        return customeResponseDTOList;
    }


}
package com.CentralBookStore.Bookstore.Bookstore.Controller;

import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import com.CentralBookStore.Bookstore.Bookstore.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/customer")
    public ResponseEntity<Customer> save(@RequestBody @Valid Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/customer")
    @ResponseBody
    public List<Customer> findAllCustomers() {
        return customerService.findCustomers();
    }
}
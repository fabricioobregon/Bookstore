package com.CentralBookStore.Bookstore.Bookstore.Controller;

import com.CentralBookStore.Bookstore.Bookstore.DTO.CustomerDTO;
import com.CentralBookStore.Bookstore.Bookstore.DTO.CustomerResponseDTO;
import com.CentralBookStore.Bookstore.Bookstore.DTO.Login;
import com.CentralBookStore.Bookstore.Bookstore.DTO.LoginValidation;
import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import com.CentralBookStore.Bookstore.Bookstore.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<CustomerResponseDTO> addUser(@RequestBody @Valid CustomerDTO customerdto) {
        Customer customer = customerService.addCustomer(customerdto.translateToObject());
        return new ResponseEntity<>(CustomerResponseDTO.translateToDTO(customer), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/update")
    public ResponseEntity<Customer> updateUser(@RequestBody @Valid Customer customer) {
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        customerService.deleteCostumer(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findall")
    @ResponseBody
    public ResponseEntity<List<CustomerResponseDTO>> findAll() {
        return new ResponseEntity<>(CustomerResponseDTO.translateToDTO(customerService.findCustomers()), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<LoginValidation> login(@RequestBody Login login) {
        if(customerService.login(login).getId().equals(UUID.fromString("00000000-0000-0000-0000-000000000000")  )){
            return new ResponseEntity<>(customerService.login(login), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(customerService.login(login), HttpStatus.OK);
    }

}
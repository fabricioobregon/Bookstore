package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import com.CentralBookStore.Bookstore.Bookstore.Repository.CustomerBookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerBookRepository customerBookRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerBookRepository customerBookRepository){
        this.customerRepository = customerRepository;
        this.customerBookRepository = customerBookRepository;
    }


    @Transactional
    public Customer addCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;
    }


    public Customer updateCustomer(Customer customer){
        Customer customerUpdate = new Customer();
        customerUpdate = customerRepository.getOne(customer.getId());
        customerUpdate.setEmail(customer.getEmail());
        customerUpdate.setName(customer.getName());
        customerUpdate.setPassword(customer.getPassword());
        customerRepository.save(customerUpdate);
        return customerUpdate;
    }

    public List<Customer> findCustomers(){ return customerRepository.findAll(); }

}

package com.CentralBookStore.Bookstore.Bookstore.Controller;

import com.CentralBookStore.Bookstore.Bookstore.Service.CustomerBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerBookController {
    private CustomerBookService customerBookService;

    @Autowired
    public CustomerBookController(CustomerBookService customerBookService) {
        this.customerBookService = customerBookService;
    }








}
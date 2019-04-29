//package com.CentralBookStore.Bookstore.Bookstore.Service;
//
//import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
//import com.CentralBookStore.Bookstore.Bookstore.Repository.CustomerBookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//public class CustomerBookService {
//    private CustomerBookRepository customerBookRepository;
//
//    @Autowired
//    public CustomerBookService(CustomerBookRepository customerBookRepository) {
//        this.customerBookRepository = customerBookRepository;
//    }
//
//    @Transactional
//    public CustomerBook addCustomerBook(CustomerBook customerBook){
//        customerBookRepository.save(customerBook);
//        return customerBook;
//    }
//
//    @Transactional
//    public CustomerBook updateCustomerBook(CustomerBook customerBook){
//        CustomerBook customerBookUpdate;
//        customerBookUpdate = customerBookRepository.getOne(customerBook.getId());
//        customerBookUpdate.setLastPage(customerBook.getLastPage());
//        return customerBookRepository.getOne(customerBook.getId());
//    }
//
//    public List<CustomerBook> findCustomerBooks(){ return customerBookRepository.findAll(); }
//
//    @Transactional
//    public void deleteCostumerBook(Long id) {
//        CustomerBook customerBook = customerBookRepository.getOne(id);
//        customerBookRepository.delete(customerBook);
//    }
//
//}

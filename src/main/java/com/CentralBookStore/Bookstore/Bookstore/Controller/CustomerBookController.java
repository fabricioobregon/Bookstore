//package com.CentralBookStore.Bookstore.Bookstore.Controller;
//
//import com.CentralBookStore.Bookstore.Bookstore.DTO.CustomerBookDTO;
//import com.CentralBookStore.Bookstore.Bookstore.DTO.CustomerBookResponseDTO;
//import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
//import com.CentralBookStore.Bookstore.Bookstore.Service.CustomerBookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/userbook")public class CustomerBookController {
//    private CustomerBookService customerBookService;
//
//    @Autowired
//    public CustomerBookController(CustomerBookService customerBookService) {
//        this.customerBookService = customerBookService;
//    }
//
//    @CrossOrigin(origins = "*")
//    @PostMapping("/add")
//    public ResponseEntity<CustomerBookResponseDTO> addUserBook(@RequestBody CustomerBookDTO customerbookdto) {
//        CustomerBook customerBook = customerBookService.addCustomerBook(customerbookdto.translateToModel());
//        return new ResponseEntity<>(CustomerBookResponseDTO.translateToDTO(customerBook), HttpStatus.CREATED);
//    }
//
//    @CrossOrigin(origins = "*")
//    @PostMapping("/update")
//    public ResponseEntity<CustomerBook> updateUserBook(@RequestBody CustomerBook customerbook) {
//        return new ResponseEntity<>(customerBookService.updateCustomerBook(customerbook), HttpStatus.ACCEPTED);
//    }
//
//    @CrossOrigin(origins = "*")
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteUserBook(@PathVariable Long id) {
//        customerBookService.deleteCostumerBook(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @CrossOrigin(origins = "*")
//    @GetMapping("/findall")
//    @ResponseBody
//    public ResponseEntity<List<CustomerBookResponseDTO>> findAll() {
//        return new ResponseEntity<>(CustomerBookResponseDTO.translateToDTO(customerBookService.findCustomerBooks()), HttpStatus.OK);
//    }
//
//}
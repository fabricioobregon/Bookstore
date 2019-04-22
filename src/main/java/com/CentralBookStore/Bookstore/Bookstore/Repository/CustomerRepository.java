package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource( collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    List<Customer> findAll();
    //Tried findById, but got crudrepository return type error
    Customer getOne(UUID id);
    Customer findCustomerByEmail(String email);
    Boolean existsByEmail(String email);
}




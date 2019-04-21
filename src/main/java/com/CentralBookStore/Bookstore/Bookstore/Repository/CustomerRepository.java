package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource( collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAll();

}


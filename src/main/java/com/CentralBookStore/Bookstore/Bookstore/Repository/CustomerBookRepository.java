package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.CustomerBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource( collectionResourceRel = "customerbooks", path = "customerbooks")
public interface CustomerBookRepository extends JpaRepository<CustomerBook, Long> {

    List<CustomerBook> findAll();
    CustomerBook getOne(Long id);

}



package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;


@RepositoryRestResource( collectionResourceRel = "books", path = "books")
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findUserBookByTitleIsLike(String string);
    List<Book> findUserBookByAuthorsIsLike(String string);
    List<Book> findUserBookByIsbn(String string);
    List<Book> findAll();
    List<Book> findAllByCustomerIdOrderByLastUpdateDesc(UUID id);
    Book findBookById(Long id);
    void deleteBookById(Long id);


}
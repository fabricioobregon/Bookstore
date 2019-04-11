package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Author;
import com.CentralBookStore.Bookstore.Bookstore.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public AuthorService() {
    }

    //
    public List<Author> addBook(Author author){
        authorRepository.save(author);
        return authorRepository.findAll();
    }

    public List<Author> find(){
        return authorRepository.findAll();
    }


}

package com.CentralBookStore.Bookstore.Bookstore.Repository;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class inMemoryBookRepository implements BookRepository{
    private final List<Book> books = new ArrayList<>();
    private Book book;


    @Override
    public void save(Book book) {
        books.add(book);
    }

    public boolean checkEmpty(){
        if (books.isEmpty()){
            System.out.println("There are no books in the store!");
            return true;
        }
        return false;
    }

    @Override
    public void findAll() {
        if (checkEmpty()){
        }
        String collect = books.stream().map(Book::toString).collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    @Override
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle() == title) {
                return book;
            }
        }
        System.out.println("There is no book with title: " + title);
        return null;
    }

    @Override
    public Book findById(String id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        System.out.println("There is no book with id: " + id);
        return null;
    }

    @Override
    public void delete(String id) {
        if(findById(id) == null) {
            return;
        }

        books.remove(findById(id));
    }
}

package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.BookManagerOptionMenu;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//@Service
public class BookManager {
    private static BookRepository bookRepository;
    private final Scanner scanner = new Scanner(System.in);
    private static final String BOOKMANAGEROPTIONMENU = "Please, selec the option from menu: \n" +
            "1 - For " + BookManagerOptionMenu.ADDBOOK + "\n" +
            "2 - For " + BookManagerOptionMenu.LISTBOOKS + "\n" +
            "3 - For " + BookManagerOptionMenu.REMOVEBOOK + "\n" +
            "4 - For " + BookManagerOptionMenu.EXIT;

    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    public void bookOperations() {
        boolean loop = true;

        do{
            switch (readKeyboard(BOOKMANAGEROPTIONMENU,4)) {
                case 1:
                    addBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    loop = false;
                    break;
            }

        }while(loop);

    }

    private void deleteBook() {
    }

    public void addBook(){
        Book book;
        book = new Book(readKeyboardString());
        System.out.println(book.toString());
        bookRepository.save(book);
    }

    public void listBooks(){
        List <Book> books;
        books = bookRepository.findAll();
        String collect = books.stream().map(Book::toString).collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    private int readKeyboard(String optionText,int numberOfOptions) {
        int choice = 0;

        while (choice < 1 || choice > numberOfOptions) {
            try {
                System.out.println(optionText);
                choice = scanner.nextInt();
                scanner.nextLine();
                if(choice < 1 || choice > numberOfOptions){ System.out.println("INVALID OPTION!"); }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("INVALID OPTION!");
            }
        }
        System.out.println("The choice number is " + choice);
        return choice;
    }

    private String readKeyboardString() {
        String title;
        System.out.println("Please, type the book title:");
        title = scanner.nextLine();
        return title;
    }


}

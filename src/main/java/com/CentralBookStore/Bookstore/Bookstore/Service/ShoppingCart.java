package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Utilities.ReadKeyboard;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private UserMode userMode;
    private String shoppingCartID;
    private BookRepository bookRepository;
    private BookRepository cartRepository;
    private static final String SHOPPINGCARTOPTIONMENU = "Please, selec the option from menu: \n" +
            "1 - To show your cart items\n" +
            "2 - To add a book to the cart\n" +
            "3 - To remove a book from the cart\n" +
            "4 - To checkout\n" +
            "5 - to return to previous menu";

    public ShoppingCart(UserMode userMode, String shoppingCartID, BookRepository cartRepository, BookRepository bookRepository) {
        this.userMode = userMode;
        this.shoppingCartID = shoppingCartID;
        this.cartRepository = cartRepository;
        this.bookRepository = bookRepository;
    }

    public void execute(){
        if(userMode != userMode.VISITOR){
            cartOperations();
        } else {
            System.out.println("You do not have access logged as " + this.userMode);
        }
    }

    public void cartOperations() {
        boolean loop = true;
        do{
            switch (ReadKeyboard.numberUsingMenu(SHOPPINGCARTOPTIONMENU,5)) {
                case 1:
                    showCart();
                    break;
                case 2:
                    addBookToCart();
                    break;
                case 3:
                    removeBookFromCart();
                    break;
                case 4:
                    checkOut();
                    loop = false;
                    break;
                case 5:
                    loop = false;
                    break;
            }
        }while(loop);
    }

    public void showCart(){
        if(cartRepository.isEmpty()){
            System.out.println("CartID: " + shoppingCartID + " is empty");
            return;
        }
        String collect = cartRepository.findAll().stream().map(Book::toString).collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    public void addBookToCart() {
        Book book;
        book = BookSearch.findById();
        System.out.println(book.toString());
        cartRepository.save(book);
    }

    public void removeBookFromCart(){
        if(cartRepository.isEmpty()){
            return;
        }
        String id = ReadKeyboard.text("Type the id to delete the book");
        cartRepository.delete(id);
    }

    public void checkOut(){
        System.out.println("Order number " + shoppingCartID);
        showCart();
        System.out.println("Thank you for buying with us!");
    }

}

package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.BookstoreApplication;
import com.CentralBookStore.Bookstore.Bookstore.Model.Book;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Utilities.ReadKeyboard;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ShoppingCart {
    private UserMode userMode;
    private String shoppingCartID;
    private BookRepository bookRepository;
    private BookRepository cartRepository;
    private Book book;
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

    public String execute(){
        if(userMode != userMode.VISITOR){
            String state = cartOperations();
            if (state == null) {
            }else if(state.equals("finished")){
                return "finished";
            }
        } else {
            System.out.println("You do not have access logged as " + this.userMode);
        }
        return null;
    }

    private String cartOperations() {
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
                    String state = checkOut();
                    if(state == null){
                        break;
                    }else if (state.equals("finished")){
                        return "finished";
                    }
                    loop = false;
                    break;
                case 5:
                    loop = false;
                    break;
            }
        }while(loop);
        return null;
    }

    private void showCart(){
        if(cartRepository.isEmpty()){
            System.out.println("CartID: " + shoppingCartID + " is empty");
            return;
        }
        String collect = cartRepository.findAll().stream().map(Book::toString).collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    private void addBookToCart() {
        book = BookSearch.findById();
        if(book == null){
            return;
        }
        System.out.println(book.toString());
        cartRepository.save(book);
    }

    private void removeBookFromCart(){
        if(cartRepository.isEmpty()){
            return;
        }
        book = BookSearch.findById();
        if(book == null){
            return;
        }
        cartRepository.delete(book.getId());
    }

    private String checkOut(){
        if(cartRepository.isEmpty()){
            System.out.println("CartID: " + shoppingCartID + " is empty");
            return null;
        }
        System.out.println("Order number " + shoppingCartID);
        showCart();
        System.out.println("Thank you for buying with us!");
        return "finished";
    }

}

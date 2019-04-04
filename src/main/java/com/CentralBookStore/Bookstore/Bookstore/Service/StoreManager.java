package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.OptionMenu;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.inMemoryBookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Utilities.ReadKeyboard;

import java.security.InvalidParameterException;
import java.util.UUID;

public class StoreManager {
    public Enum USERMODE;
    public BookRepository bookRepository;
    public BookRepository cartRepository;
    public BookManager bookManager;
    public BookSearch booksearch;
    public String shoppingCartID;
    public ShoppingCart shoppingCart;
    public final String USERMODETEXT = "Please, selec the user mode: \n" +
            "1 - For " + UserMode.ADMIN + "\n" +
            "2 - For " + UserMode.USER + "\n" +
            "3 - For " + UserMode.VISITOR;
    public final String OPTIONMENU = "Please, selec the option from menu: \n" +
            "1 - For " + OptionMenu.SEARCHBOOK + "\n" +
            "2 - For " + OptionMenu.SHOPPINGCART + "\n" +
            "3 - For " + OptionMenu.BOOKMANAGER + "\n" +
            "4 - For " + OptionMenu.EXIT;

    public StoreManager() {
        this.USERMODE = userModeSelected();
        this.bookRepository = new inMemoryBookRepository();
        this.cartRepository = new inMemoryBookRepository();
        this.bookManager = new BookManager((UserMode) this.USERMODE,bookRepository);
        this.booksearch = new BookSearch(bookRepository);
        this.shoppingCartID = UUID.randomUUID().toString();
        this.shoppingCart = new ShoppingCart((UserMode) this.USERMODE,shoppingCartID, cartRepository, bookRepository);
    }

    public void execute() {
        optionMenu();
    }

    public Enum userModeSelected() {
        switch (ReadKeyboard.number(USERMODETEXT,3)) {
            case 1:
                System.out.println(UserMode.ADMIN + " mode selected\n");
                return UserMode.ADMIN;
            case 2:
                System.out.println(UserMode.USER + " mode selected\n");
                return UserMode.USER;
            case 3:
                System.out.println(UserMode.VISITOR + " mode selected\n");
                return UserMode.VISITOR;
            default:
                throw new InvalidParameterException(">>>Invalid user mode selected<<<");
        }
    }

    public void optionMenu(){
        boolean loop = true;
        do{
            switch (ReadKeyboard.numberUsingMenu(OPTIONMENU,4)) {
                case 1:
                    booksearch.execute();
                    break;
                case 2:
                    shoppingCart.execute();
                    break;
                case 3:
                    bookManager.execute();
                    break;
                case 4:
                    System.out.println("Thank you for visiting our Book Store!");
                    loop = false;
                    break;
                default:
            }
        }while(loop);
    }

}
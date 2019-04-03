package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.OptionMenu;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.inMemoryBookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Utilities.ReadKeyboard;

import java.security.InvalidParameterException;

public class StoreManager {
    private BookRepository bookRepository = new inMemoryBookRepository();
    private BookManager bookManager;
    private ShoppingCart shoppingCart;
    private Enum USERMODE;
    private final String USERMODETEXT = "Please, selec the user mode: \n" +
            "1 - For " + UserMode.ADMIN + "\n" +
            "2 - For " + UserMode.USER + "\n" +
            "3 - For " + UserMode.VISITOR;
    private final String OPTIONMENU = "Please, selec the option from menu: \n" +
            "1 - For " + OptionMenu.SEARCHBOOK + "\n" +
            "2 - For " + OptionMenu.SHOPPINGCART + "\n" +
            "3 - For " + OptionMenu.BOOKMANAGER + "\n" +
            "4 - For " + OptionMenu.EXIT;

    public StoreManager() {
    }

    public void execute() {
        this.USERMODE = userModeSelected();
        System.out.println(this.USERMODE + " mode selected\n");
        optionMenu((UserMode) this.USERMODE);
    }

    public Enum userModeSelected() {
        switch (ReadKeyboard.number(USERMODETEXT,3)) {
            case 1:
                return UserMode.ADMIN;
            case 2:
                return UserMode.USER;
            case 3:
                return UserMode.VISITOR;
            default:
                throw new InvalidParameterException(">>>Invalid user mode selected<<<");
        }
    }

    public void optionMenu(UserMode userMode){
        boolean loop = true;
        do{
            switch (ReadKeyboard.numberUsingMenu(OPTIONMENU,4)) {
                case 1:
                    new BookSearch(userMode,bookRepository).execute();
                    break;
                case 2:
                    new ShoppingCart(userMode,bookRepository).execute();
                    break;
                case 3:
                    new BookManager(userMode,bookRepository).execute();
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
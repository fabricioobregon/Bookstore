package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.OptionMenu;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.inMemoryBookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Utilities.ReadKeyboard;

import java.security.InvalidParameterException;
import java.util.UUID;

public class StoreManager {
    private Enum USERMODE;
    private final static BookRepository bookRepository = new inMemoryBookRepository();
    private BookRepository cartRepository;
    private BookManager bookManager;
    private BookSearch booksearch;
    private String shoppingCartID;
    private ShoppingCart shoppingCart;
    private static final String USERMODETEXT = "Please, selec the user mode: \n" +
            "1 - For " + UserMode.ADMIN + "\n" +
            "2 - For " + UserMode.USER + "\n" +
            "3 - For " + UserMode.VISITOR;
    private final String OPTIONMENU = "Please, selec the option from menu: \n" +
            "1 - For " + OptionMenu.SEARCHBOOK + "\n" +
            "2 - For " + OptionMenu.SHOPPINGCART + "\n" +
            "3 - For " + OptionMenu.BOOKSTOREMANAGER + "\n" +
            "4 - For " + OptionMenu.EXIT;

    public StoreManager(Enum userMode) {
        this.USERMODE = userMode;
        this.cartRepository = new inMemoryBookRepository();
        this.bookManager = new BookManager((UserMode) this.USERMODE,bookRepository);
        this.booksearch = new BookSearch(bookRepository);
        this.shoppingCartID = UUID.randomUUID().toString();
        this.shoppingCart = new ShoppingCart((UserMode) this.USERMODE,shoppingCartID, cartRepository, bookRepository);
    }

    public String execute() {
        String state = optionMenu();
        if (state == null) {
        } else if (state.equals("finished")){
            return "finished";
        }
        return "operational";
    }

    public static Enum userModeSelected() {
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

    private String optionMenu(){
        boolean loop = true;
        do{
            switch (ReadKeyboard.numberUsingMenu(OPTIONMENU,4)) {
                case 1:
                    booksearch.execute();
                    break;
                case 2:
                    String state = shoppingCart.execute();
                    if(state == null) {
                        break;
                    }else if (state.equals("finished")){
                        return "finished";
                    }
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
        return null;
    }

}
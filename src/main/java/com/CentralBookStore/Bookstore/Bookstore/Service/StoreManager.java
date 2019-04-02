package com.CentralBookStore.Bookstore.Bookstore.Service;

import com.CentralBookStore.Bookstore.Bookstore.Model.OptionMenu;
import com.CentralBookStore.Bookstore.Bookstore.Model.UserMode;
import com.CentralBookStore.Bookstore.Bookstore.Repository.BookRepository;
import com.CentralBookStore.Bookstore.Bookstore.Repository.inMemoryBookRepository;
import org.springframework.stereotype.Controller;
import java.security.InvalidParameterException;
import java.util.Scanner;

//@Controller
public class StoreManager {
    private BookRepository bookRepository = new inMemoryBookRepository();
    private BookManager bookManager  = new BookManager(bookRepository);
    private ShoppingCart shoppingCart = new ShoppingCart(bookRepository);
    private Scanner scanner = new Scanner(System.in);
    private final Enum USERMODE;
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
        this.USERMODE = userModeSelected();
        System.out.println(this.USERMODE + " mode selected\n");
    }

    public Enum userModeSelected() {
        switch (readKeyboard(USERMODETEXT,3)) {
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

    public void execute() {
        boolean loop = true;

        do{
            switch (readKeyboard(OPTIONMENU,4)) {
                case 1:
                    new BookSearch();
                    break;
                case 2:
                    if(USERMODE.equals(UserMode.VISITOR)){
                        System.out.println("You do not have permission to start a Shopping Cart!");
                    } else {
                        shoppingCart.cartOperations();
                    }
                    break;
                case 3:
                    if(USERMODE.equals(UserMode.ADMIN)){
                        System.out.println("Managing Books");
                        bookManager.bookOperations();
                    } else {
                        System.out.println("You do not have permission to manage books!");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for visiting our Book Store!");
                    loop = false;
                    break;
            }

        }while(loop);

    }

    private int readKeyboard(String userModeText, int numberOfOptions) {
        int choice = 0;

        while (choice < 1 || choice > numberOfOptions) {
            try {
                System.out.println(userModeText);
                choice = scanner.nextInt();
                scanner.nextLine();
                if(choice < 1 || choice > numberOfOptions){ System.out.println("INVALID OPTION!"); }
            } catch (Exception e) {
                System.out.println("INVALID OPTION!");
                scanner.nextLine();
            }
        }

        System.out.println("The choice number is " + choice);
        return choice;
    }

}
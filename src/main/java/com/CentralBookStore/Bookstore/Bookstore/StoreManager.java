package com.CentralBookStore.Bookstore.Bookstore;

import java.awt.*;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class StoreManager {
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

    private int readKeyboard(String usermodetext, int numberOfOptions) {
        int choice = 0;

        if (numberOfOptions == 2) {
            while (choice != 1 && choice != 2) {
                try {
                    System.out.println(usermodetext);
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("INVALID OPTION!");
                    scanner.nextLine();
                }
            }


        } else if (numberOfOptions == 3) {
            while (choice != 1 && choice != 2 && choice != 3) {
                try {
                    System.out.println(usermodetext);
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("INVALID OPTION!");
                    scanner.nextLine();
                }
            }

        } else if (numberOfOptions == 4) {
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                try {
                    System.out.println(usermodetext);
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("INVALID OPTION!");
                    scanner.nextLine();
                }
            }

        }
        System.out.println("The choice number is " + choice);
        return choice;

    }


    public void execute() {
        boolean loop = true;
        
        do{
            switch (readKeyboard(OPTIONMENU,4)) {
                case 1:
                    new BookSearch(this.USERMODE);
                    break;
                case 2:
                    new ShoppingCart(this.USERMODE);
                    break;
                case 3:
                    new BookManager(this.USERMODE);
                    break;
                case 4:
                    System.out.println("Thank you for visiting our Book Store!");
                    loop = false;
                    break;
            }
            
        }while(loop);


    }
}
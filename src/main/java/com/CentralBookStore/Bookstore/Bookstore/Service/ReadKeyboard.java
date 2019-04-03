package com.CentralBookStore.Bookstore.Bookstore.Service;

import java.util.Scanner;

public class ReadKeyboard {
    private final Scanner scanner;
    private final String optionText;
    private int numberOfOptions;

    public ReadKeyboard(Scanner scanner, String optionText, int numberOfOptions) {
        this.scanner = scanner;
        this.optionText = optionText;
        this.numberOfOptions = numberOfOptions;
    }

    public ReadKeyboard(Scanner scanner, String optionText) {
        this.scanner = scanner;
        this.optionText = optionText;
        this.numberOfOptions = 0;
    }

    public int number(Scanner scanner, String optionText, int numberOfOptions) {
        int choice = 0;
        while (choice < 1 || choice > numberOfOptions) {
            try {
                System.out.println(optionText);
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("INVALID OPTION!");
                scanner.nextLine();
            }
        }
        System.out.println("The choice number is " + choice);
        return choice;
    }

    public int numberUsingMenu(Scanner scanner, String optionMenuText, int numberOfOptions) {
        int choice = 0;
        while (choice < 1 || choice > numberOfOptions) {
            try {
                System.out.println(optionMenuText);
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

    public String text(Scanner scanner, String optionText) {
        System.out.println(optionText);
        return scanner.nextLine();
    }

}

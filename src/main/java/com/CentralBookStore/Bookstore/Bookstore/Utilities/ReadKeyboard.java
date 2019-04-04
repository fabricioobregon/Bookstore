package com.CentralBookStore.Bookstore.Bookstore.Utilities;

import java.util.Scanner;

public class ReadKeyboard {
    private static final Scanner scanner = new Scanner(System.in);
    private static String optionText;
    private static int numberOfOptions;

    public ReadKeyboard(String optionText, int numberOfOptions) {
    }

    public static int number(String optionText, int numberOfOptions) {
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

    public static int numberUsingMenu(String optionMenuText, int numberOfOptions) {
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

    public static String text(String optionText) {
        String textInput = "";
        while (textInput == "") {
            try {
                System.out.println(optionText);
                textInput = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("INVALID OPTION!");
            }
        }
        return textInput;
    }









}

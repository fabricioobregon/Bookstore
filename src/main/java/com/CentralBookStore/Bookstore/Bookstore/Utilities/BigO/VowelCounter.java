package com.CentralBookStore.Bookstore.Bookstore.Utilities.BigO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VowelCounter {

    public static final List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) {
        while (true) {
            System.out.println("Please enter a string");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            long startTime = System.nanoTime();
            int result = countVowels(input);
            System.out.println(result + " vowels in " + (System.nanoTime() - startTime) + " nanoseconds");
        }


    }

    private static int countVowels(String input) {
        int wordcount = 0;
        return wordcount;




    }


}
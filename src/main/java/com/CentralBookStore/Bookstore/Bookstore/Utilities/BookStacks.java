package com.CentralBookStore.Bookstore.Bookstore.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookStacks {
    private static final Scanner scanner = new Scanner(System.in);
    private static int stackSize, maxStableSize, partitionsAllowed;
    private static List<Integer> partitionSize = new ArrayList<>();

    public BookStacks() {
    }
    
    public static void execute(BookStacks bookStacks) {
        System.out.println("Welcome to Stack Calculator\n" +
                "Please insert the following numbers in the same line separated by a space\n" +
                "Number of books within 1 and 100\n" +
                "Maximum stable high for the stack within 1 and 5\n" +
                "Maximum partitions allowed within 2 and 5");
        stackSize = Integer.parseInt(scanner.next());
        maxStableSize = Integer.parseInt(scanner.next());
        partitionsAllowed = Integer.parseInt(scanner.next());
        scanner.close();
        System.out.println("The number of partitions is " + splitBooks(stackSize, maxStableSize, partitionsAllowed, partitionSize));
        int i=1;
        for (int item:partitionSize) {
        System.out.println("Partition" + i +  ": " +item);
        i++;
        }
    }

    public static int splitBooks(int stackSize, int maxStableSize, int partitionsAllowed, List<Integer> partitionSize){

        if (stackSize <= 0){
            return 0;

        } else if(stackSize <= maxStableSize){
            partitionSize.add(stackSize);
            return 1;
        } else {
            int numStacks = 0;
            int newBaseStackSize = stackSize/partitionsAllowed;
            int extraBooks = stackSize%partitionsAllowed;
            int newStackSize;

            for (int i = 0; i < partitionsAllowed; i++) {

                newStackSize = newBaseStackSize + (extraBooks > 0 ? 1 : 0);
                extraBooks--;

                numStacks += splitBooks(newStackSize, maxStableSize, partitionsAllowed, partitionSize);
            }
            return numStacks;
        }
    }

    public static void main(String[] args) {
        BookStacks bookStacks = new BookStacks();
        BookStacks.execute(bookStacks);
    }
}

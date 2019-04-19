package com.CentralBookStore.Bookstore.Bookstore.Utilities.BigO;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CallAvengers {


    public static void main(String[] args) {
        while(true){
        System.out.println("Please enter two integers");
        Scanner scanner = new Scanner(System.in);
        int inputA = scanner.nextInt();
        int inputB = scanner.nextInt();
        scanner.nextLine();
        long startTime = System.nanoTime();
        callAvengers(inputA, inputB);
        System.out.println("\nCalled Avengers in " + (System.nanoTime() - startTime) + " nanoseconds");
        }
    }

    private static void callAvengers(int min, int max) {
        List<Integer> primeArray = CreatePrimeArray(max);

        for (int i=0;i<min;i++){
            if(primeArray.contains(i)) {
                primeArray.remove(Integer.valueOf(i));
            }
        }
        for (int i:primeArray) {
            System.out.print(i + " ");
        }
        //System.out.println(primeArray.size());
    }

    private static List<Integer> CreatePrimeArray(int max) {
        List<Integer> localList = new ArrayList<>();

        for(int number=0;number<=max;number++){
            if(isPrime(number) && isPrime(sumDigits(number))){
                localList.add(number);
            }
        }
        return localList;
    }

    private static boolean isPrime(int number) {
        if(number < 2){
            return false;
        }
        if (number == 2){
            return true;
        }
        if (number%2==0){
            return false;
        }
        for(int i=3;i*i<=number;i+=2) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    private static int sumDigits(int number){
        int result = 0;
        while (number>0) {
            result = result + (number%10);
            number=number/10;
        }
        return result;
    }
}
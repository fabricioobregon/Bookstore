package com.CentralBookStore.Bookstore.Bookstore.Utilities.lambdasAndStreams;

public class Lambdas {

    public static void main(String[] args) {

        MathOperation additionOperation = (a, b) -> a+b;

        printMathResult(1,2,additionOperation);
        printMathResult(2,3,(a,b) -> a*b);
        printMathResult(6,2,(doesntMatter, whatYouCallThese) -> {return doesntMatter/whatYouCallThese;});
        printMathResult(5,3,(Lambdas::modeOperation));

    }

    @FunctionalInterface
    private interface MathOperation{
        int operate(int a, int b);
    }

    public static void printMathResult(int a, int b, MathOperation mathOperation) {
        System.out.println(mathOperation.operate(a,b));
    }

    static int modeOperation(int a, int b){
        return a%b;
    }



}

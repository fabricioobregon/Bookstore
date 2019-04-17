package com.CentralBookStore.Bookstore.Bookstore.Utilities.lambdasAndStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        List<Integer> myIntList = Arrays.asList(1,2,3,4,5,6,7,8,9);

        List<Integer> myModifiedList = myIntList.stream()
                .filter(myInt -> myInt > 4)
                .map(myFilteredInt -> myFilteredInt*myFilteredInt)
                .sorted((a,b) -> {
                    if(a>b){
                        return -1;
                    }else if(b>a){
                        return 1;
                    }else {
                        return 0;
                    }
                })
               .peek(System.out::println)
               .collect(Collectors.toList());
    }



}

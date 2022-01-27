package com.company.FunctionalProgramming;

import java.util.List;

public class FB01Structured {
    public static void main(String[] args) {
        printAllNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));

        System.out.println("------------ Squares of Numbers --------------");

        printSquaresOfNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        // structured approachFB01Structured
        // how to loop the numbers
        for(int number: numbers){
            System.out.println(number);
        }
    }

    private static void printSquaresOfNumbersInListStructured(List<Integer> numbers) {
        // structured approachFB01Structured
        // how to loop the numbers
        for(int number: numbers){
            System.out.println(number*number);


        }
    }


}

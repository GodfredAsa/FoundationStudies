package com.company.FunctionalProgramming;

import java.util.Comparator;
import java.util.List;


import static java.util.stream.Collectors.toList;

public class FB01Functional {
    public static void main(String[] args) {



        printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));

        System.out.println("Even numbers: " +
                printAllEvenNumbers(List.of(12,9,13,4,6,2,4,12,15)));

        System.out.println("Odd numbers: " +
        getAllOddNumbers(List.of(12,9,13,4,6,2,4,12,15)));

        System.out.println(
                "squares of even numbers: " +
                getSquaresOfEvenNumbers(List.of(12,9,13,4,6,2,4,12,15)));


        System.out.println("Cubes of odd numbers: " +
                getCubesOfOddNumbers(List.of(12,9,13,4,6,2,4,12,15)));

        System.out.println( "Sum of numbers: " +
                sumAllNumbers(List.of(12,9,13,4,6,2,4,12,15)));

        System.out.println("Sum of Square of distinct Numbers: "
                + sumSquareOfDistinctNumbers(List.of(12,9,13,4,6,2,4,12,15)));
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {

        System.out.println( "List of Numbers: " + numbers);
    }



// prints even numbers sorted in descending order
    public static List<Integer> printAllEvenNumbers(List<Integer> numbers){
      return  numbers.stream()
              .filter(FB01Functional::isEven)
              .sorted(Comparator.reverseOrder())
              .collect(toList());
    }


    public  static List<Integer> getAllOddNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(FB01Functional::isOdd)
                .sorted()
                .collect(toList());
    }

    static List<Integer> getSquaresOfEvenNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(FB01Functional::isEven)
                .map(squareEvenNumber -> Math.pow(2,squareEvenNumber))
                .map(Double::intValue)
                .collect(toList());

    }


    public static List<Integer> getCubesOfOddNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(FB01Functional::isOdd)
                .map(cubeOfOddNumber -> Math.pow(3,cubeOfOddNumber))
                .map(Double::intValue)
                .collect(toList());
    }

    public static int sumSquareOfDistinctNumbers(List<Integer> numbers){
        return numbers.stream()
                .distinct()
                .map(square -> Math.pow(2, square))
                .map(Double::intValue)
                .reduce(0,Integer::sum);
    }




    public static int sumAllNumbers(List<Integer> numbers){
        return numbers.stream()
                .reduce(0,Integer::sum);
    }

    public static boolean isEven(int number){
        return number%2 == 0;
    }

    public static boolean isOdd(int number){
        return number%2 == 1;
    }

}
package com.company.BehaviourParametization;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// this work space demonstrate behavior parameterization
public class FB03BehaviourParameterization {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);


        filterAndPrint(numbers, x -> x % 3 == 0);
        System.out.println("--------------------");
        filterAndPrint(numbers, x -> x % 4 == 0);
        

        System.out.println( "real numbers: " + numbers);


        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x-> x*2);
        System.out.println( "double numbers: " + doubledNumbers);


        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, mappingFunction);
        System.out.println( "squared numbers: " + squaredNumbers);


        List<Integer> cubesOfNumbers = mapAndCreateNewList(numbers, x-> x*x*x);
        System.out.println( "cubed numbers: " + cubesOfNumbers);


        List<String> str = List.of("Hello", "Banana", "Sugar", "Horse");
        List<Integer> stringToIntegerList = mapStrToIntegerList(str);
        System.out.println( "lists of strings to numbers: " + stringToIntegerList);


// supplier takes no input but returns a value ** this function prints even if the random value is even or odd if so.
        Supplier<String> returnEvenOrOdd = () -> {
                        Random random  =  new Random();
                        int result = random.nextInt(100);
                        return result % 2 == 0 ? "even number"  :  "odd number";
        };


        System.out.println( "supplier method = " + returnEvenOrOdd.get());

        System.out.println( "test is running: " + createListTest(numbers, t-> t * 10));

    }


    private static List<Integer> createListTest(List<Integer> testNumbers, Function<Integer, Integer> testFunc){
        return testNumbers.stream()
                .map(testFunc)
                .collect(Collectors.toList());
    }



    private static final Function<Integer, Integer> mappingFunction  = x -> x * x;
    private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }



    private static final Function<String, Integer> strToInteger = String::length;
    private static   List<Integer> mapStrToIntegerList(List<String> str){
       return str.stream()
                .map(FB03BehaviourParameterization.strToInteger)
                .collect(Collectors.toList());
    }


    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> integerPredicate) {
        numbers.stream()
                .filter(integerPredicate)
                .forEach(System.out::println);
    }






}
